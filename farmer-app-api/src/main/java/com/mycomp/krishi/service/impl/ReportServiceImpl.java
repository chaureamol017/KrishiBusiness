package com.mycomp.krishi.service.impl;

import com.mycomp.krishi.persistence.entity.FarmerProduct;
import com.mycomp.krishi.persistence.entity.FarmerProductBid;
import com.mycomp.krishi.persistence.repository.FarmerProductBidRepository;
import com.mycomp.krishi.persistence.repository.FarmerProductRepository;
import com.mycomp.krishi.persistence.repository.ProductRepository;
import com.mycomp.krishi.persistence.repository.UserRepository;
import com.mycomp.krishi.service.api.ReportService;
import com.mycomp.krishi.web.v1.model.AdminReportResponse;
import com.mycomp.krishi.web.v1.model.BuyerReportResponse;
import com.mycomp.krishi.web.v1.model.SellerReportResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

	private final FarmerProductRepository farmerProductRepository;
	private final FarmerProductBidRepository farmerProductBidRepository;
	private final ProductRepository productRepository;
	private final UserRepository userRepository;

	@Autowired
	public ReportServiceImpl(FarmerProductRepository farmerProductRepository,
							 FarmerProductBidRepository farmerProductBidRepository,
							 ProductRepository productRepository,
							 UserRepository userRepository) {
		this.farmerProductRepository = farmerProductRepository;
		this.farmerProductBidRepository = farmerProductBidRepository;
		this.productRepository = productRepository;
		this.userRepository = userRepository;
	}

	@Override
	public SellerReportResponse getSellerReport(Long userId) {
		SellerReportResponse response = new SellerReportResponse();

		List<FarmerProduct> products = farmerProductRepository.findByUserId(userId);

		long totalListed = products.size();
		long totalSold = products.stream().filter(fp -> Boolean.TRUE.equals(fp.isSold())).count();
		long totalUnsold = totalListed - totalSold;

		double totalRevenue = products.stream()
				.filter(fp -> Boolean.TRUE.equals(fp.isSold()))
				.mapToDouble(fp -> fp.getPricePerUnit() * fp.getQuantity())
				.sum();

		double avgPrice = products.stream()
				.mapToDouble(FarmerProduct::getPricePerUnit)
				.average()
				.orElse(0.0);

		response.setTotalProductsListed(totalListed);
		response.setTotalProductsSold(totalSold);
		response.setTotalProductsUnsold(totalUnsold);
		response.setTotalRevenue(totalRevenue);
		response.setAveragePricePerUnit(Math.round(avgPrice * 100.0) / 100.0);

		List<SellerReportResponse.ProductSalesDetail> details = new ArrayList<>();
		for (FarmerProduct fp : products) {
			SellerReportResponse.ProductSalesDetail detail = new SellerReportResponse.ProductSalesDetail();
			detail.setProductName(fp.getProduct() != null ? fp.getProduct().getName() : "");
			detail.setCategory(fp.getProduct() != null ? fp.getProduct().getCategory() : "");
			detail.setQuantity(fp.getQuantity());
			detail.setQuantityUnit(fp.getQuantityUnit());
			detail.setPricePerUnit(fp.getPricePerUnit());
			detail.setCity(fp.getCity());
			detail.setAddedOn(fp.getAddedOn() != null ? DATE_FORMAT.format(fp.getAddedOn()) : "");
			detail.setSoldOn(fp.getSoldOn() != null ? DATE_FORMAT.format(fp.getSoldOn()) : "");
			detail.setSold(Boolean.TRUE.equals(fp.isSold()));
			detail.setTotalValue(fp.getPricePerUnit() * fp.getQuantity());
			details.add(detail);
		}
		response.setProductSalesDetails(details);

		return response;
	}

	@Override
	public BuyerReportResponse getBuyerReport(Long userId) {
		BuyerReportResponse response = new BuyerReportResponse();

		List<FarmerProductBid> allBids = farmerProductBidRepository.findByBuyerUserId(userId);
		List<FarmerProductBid> acceptedBids = farmerProductBidRepository.findByBuyerUserIdAndAcceptedIsTrue(userId);

		long totalPlaced = allBids.size();
		long totalAccepted = acceptedBids.size();
		long totalPending = totalPlaced - totalAccepted;

		double totalSpent = acceptedBids.stream()
				.mapToDouble(FarmerProductBid::getQuotedPricePerUnit)
				.sum();

		double avgQuoted = allBids.stream()
				.mapToDouble(FarmerProductBid::getQuotedPricePerUnit)
				.average()
				.orElse(0.0);

		response.setTotalBidsPlaced(totalPlaced);
		response.setTotalBidsAccepted(totalAccepted);
		response.setTotalBidsPending(totalPending);
		response.setTotalAmountSpent(totalSpent);
		response.setAverageQuotedPrice(Math.round(avgQuoted * 100.0) / 100.0);

		List<BuyerReportResponse.BidDetail> details = new ArrayList<>();
		for (FarmerProductBid bid : allBids) {
			BuyerReportResponse.BidDetail detail = new BuyerReportResponse.BidDetail();
			detail.setFarmerProductId(bid.getFarmerProductId());

			Optional<FarmerProduct> fpOpt = farmerProductRepository.findById(bid.getFarmerProductId());
			if (fpOpt.isPresent()) {
				FarmerProduct fp = fpOpt.get();
				detail.setProductName(fp.getProduct() != null ? fp.getProduct().getName() : "");
				detail.setCategory(fp.getProduct() != null ? fp.getProduct().getCategory() : "");
			} else {
				detail.setProductName("");
				detail.setCategory("");
			}

			detail.setQuotedPricePerUnit(bid.getQuotedPricePerUnit());
			detail.setBidOn(bid.getBidOn() != null ? DATE_FORMAT.format(bid.getBidOn()) : "");
			detail.setAcceptedOn(bid.getAcceptedOn() != null ? DATE_FORMAT.format(bid.getAcceptedOn()) : "");
			detail.setAccepted(Boolean.TRUE.equals(bid.isAccepted()));
			details.add(detail);
		}
		response.setBidDetails(details);

		return response;
	}

	@Override
	public AdminReportResponse getAdminReport() {
		AdminReportResponse response = new AdminReportResponse();

		response.setTotalUsers(userRepository.count());
		response.setTotalProducts(productRepository.count());
		response.setTotalFarmerProducts(farmerProductRepository.countAllProducts());
		response.setTotalFarmerProductsSold(farmerProductRepository.countAllSoldProducts());
		response.setTotalFarmerProductsUnsold(response.getTotalFarmerProducts() - response.getTotalFarmerProductsSold());
		response.setTotalBids(farmerProductBidRepository.countAllBids());
		response.setTotalAcceptedBids(farmerProductBidRepository.countAllAcceptedBids());

		List<FarmerProduct> allSold = farmerProductRepository.findAll().stream()
				.filter(fp -> Boolean.TRUE.equals(fp.isSold()))
				.toList();
		double platformRevenue = allSold.stream()
				.mapToDouble(fp -> fp.getPricePerUnit() * fp.getQuantity())
				.sum();
		response.setPlatformTotalRevenue(platformRevenue);

		return response;
	}
}
