package com.mycomp.krishi.service.impl;

import com.mycomp.krishi.persistence.entity.FarmerProduct;
import com.mycomp.krishi.persistence.entity.FarmerProductBid;
import com.mycomp.krishi.persistence.entity.User;
import com.mycomp.krishi.persistence.repository.FarmerProductBidRepository;
import com.mycomp.krishi.persistence.repository.FarmerProductRepository;
import com.mycomp.krishi.persistence.repository.UserRepository;
import com.mycomp.krishi.service.api.TransactionService;
import com.mycomp.krishi.web.v1.model.TransactionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

	private final FarmerProductRepository farmerProductRepository;
	private final FarmerProductBidRepository farmerProductBidRepository;
	private final UserRepository userRepository;

	@Autowired
	public TransactionServiceImpl(FarmerProductRepository farmerProductRepository,
								  FarmerProductBidRepository farmerProductBidRepository,
								  UserRepository userRepository) {
		this.farmerProductRepository = farmerProductRepository;
		this.farmerProductBidRepository = farmerProductBidRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<TransactionResponse> getSellerTransactions(Long userId) {
		List<FarmerProduct> soldProducts = farmerProductRepository.findSoldByUserId(userId);
		return buildTransactions(soldProducts);
	}

	@Override
	public List<TransactionResponse> getBuyerTransactions(Long userId) {
		List<FarmerProductBid> acceptedBids = farmerProductBidRepository.findByBuyerUserIdAndAcceptedIsTrue(userId);
		List<TransactionResponse> transactions = new ArrayList<>();

		for (FarmerProductBid bid : acceptedBids) {
			Optional<FarmerProduct> fpOpt = farmerProductRepository.findById(bid.getFarmerProductId());
			if (fpOpt.isPresent()) {
				FarmerProduct fp = fpOpt.get();
				TransactionResponse tx = buildTransaction(fp, bid);
				transactions.add(tx);
			}
		}
		return transactions;
	}

	@Override
	public List<TransactionResponse> getAllTransactions() {
		List<FarmerProduct> soldProducts = farmerProductRepository.findAllSoldProducts();
		return buildTransactions(soldProducts);
	}

	private List<TransactionResponse> buildTransactions(List<FarmerProduct> soldProducts) {
		List<TransactionResponse> transactions = new ArrayList<>();

		for (FarmerProduct fp : soldProducts) {
			FarmerProductBid acceptedBid = farmerProductBidRepository.findAcceptedBidForProduct(fp.getFarmerProductId());
			TransactionResponse tx = buildTransaction(fp, acceptedBid);
			transactions.add(tx);
		}
		return transactions;
	}

	private TransactionResponse buildTransaction(FarmerProduct fp, FarmerProductBid bid) {
		TransactionResponse tx = new TransactionResponse();
		tx.setFarmerProductId(fp.getFarmerProductId());
		tx.setProductName(fp.getProduct() != null ? fp.getProduct().getName() : "");
		tx.setCategory(fp.getProduct() != null ? fp.getProduct().getCategory() : "");
		tx.setQuantity(fp.getQuantity());
		tx.setQuantityUnit(fp.getQuantityUnit());
		tx.setPricePerUnit(fp.getPricePerUnit());
		tx.setTotalAmount(fp.getPricePerUnit() * fp.getQuantity());
		tx.setCity(fp.getCity());
		tx.setSellerUserId(fp.getUserId());
		tx.setSoldOn(fp.getSoldOn());

		String sellerName = getUserName(fp.getUserId());
		tx.setSellerName(sellerName);

		if (bid != null) {
			tx.setTransactionId(bid.getFarmerProductBidId());
			tx.setBuyerUserId(bid.getBuyerUserId());
			tx.setQuotedPricePerUnit(bid.getQuotedPricePerUnit());
			tx.setBidAcceptedOn(bid.getAcceptedOn());
			tx.setBuyerName(getUserName(bid.getBuyerUserId()));
		}

		return tx;
	}

	private String getUserName(Long userId) {
		if (userId == null) return "";
		Optional<User> userOpt = userRepository.findById(userId);
		if (userOpt.isPresent()) {
			User user = userOpt.get();
			return (user.getFirstName() != null ? user.getFirstName() : "") +
				   (user.getLastName() != null ? " " + user.getLastName() : "");
		}
		return "";
	}
}
