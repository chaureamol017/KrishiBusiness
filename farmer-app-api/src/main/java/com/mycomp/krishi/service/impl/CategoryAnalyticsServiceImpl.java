package com.mycomp.krishi.service.impl;

import com.mycomp.krishi.persistence.entity.FarmerProduct;
import com.mycomp.krishi.persistence.entity.FarmerProductBid;
import com.mycomp.krishi.persistence.repository.FarmerProductBidRepository;
import com.mycomp.krishi.persistence.repository.FarmerProductRepository;
import com.mycomp.krishi.service.api.CategoryAnalyticsService;
import com.mycomp.krishi.web.v1.model.CategoryAnalyticsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryAnalyticsServiceImpl implements CategoryAnalyticsService {

	private final FarmerProductRepository farmerProductRepository;
	private final FarmerProductBidRepository farmerProductBidRepository;

	@Autowired
	public CategoryAnalyticsServiceImpl(FarmerProductRepository farmerProductRepository,
										FarmerProductBidRepository farmerProductBidRepository) {
		this.farmerProductRepository = farmerProductRepository;
		this.farmerProductBidRepository = farmerProductBidRepository;
	}

	@Override
	public CategoryAnalyticsResponse getCategoryAnalytics() {
		List<FarmerProduct> allProducts = farmerProductRepository.findAll();
		List<FarmerProductBid> allBids = farmerProductBidRepository.findAll();

		// Build a map from farmerProductId -> category
		Map<Long, String> productCategoryMap = new HashMap<>();
		for (FarmerProduct fp : allProducts) {
			String category = (fp.getProduct() != null && fp.getProduct().getCategory() != null)
					? fp.getProduct().getCategory() : "UNKNOWN";
			productCategoryMap.put(fp.getFarmerProductId(), category);
		}

		// Products by category
		Map<String, Long> productsByCategory = allProducts.stream()
				.collect(Collectors.groupingBy(
						fp -> fp.getProduct() != null && fp.getProduct().getCategory() != null
								? fp.getProduct().getCategory() : "UNKNOWN",
						Collectors.counting()));

		// Sold by category
		Map<String, Long> soldByCategory = allProducts.stream()
				.filter(fp -> Boolean.TRUE.equals(fp.isSold()))
				.collect(Collectors.groupingBy(
						fp -> fp.getProduct() != null && fp.getProduct().getCategory() != null
								? fp.getProduct().getCategory() : "UNKNOWN",
						Collectors.counting()));

		// Revenue by category
		Map<String, Double> revenueByCategory = allProducts.stream()
				.filter(fp -> Boolean.TRUE.equals(fp.isSold()))
				.collect(Collectors.groupingBy(
						fp -> fp.getProduct() != null && fp.getProduct().getCategory() != null
								? fp.getProduct().getCategory() : "UNKNOWN",
						Collectors.summingDouble(fp -> fp.getPricePerUnit() * fp.getQuantity())));

		// Bids by category
		Map<String, Long> bidsByCategory = allBids.stream()
				.collect(Collectors.groupingBy(
						bid -> productCategoryMap.getOrDefault(bid.getFarmerProductId(), "UNKNOWN"),
						Collectors.counting()));

		// Build category details
		Set<String> allCategories = new TreeSet<>();
		allCategories.addAll(productsByCategory.keySet());
		allCategories.addAll(soldByCategory.keySet());

		List<CategoryAnalyticsResponse.CategoryDetail> details = new ArrayList<>();
		for (String category : allCategories) {
			CategoryAnalyticsResponse.CategoryDetail detail = new CategoryAnalyticsResponse.CategoryDetail();
			detail.setCategory(category);
			detail.setTotalProducts(productsByCategory.getOrDefault(category, 0L));
			detail.setTotalSold(soldByCategory.getOrDefault(category, 0L));
			detail.setTotalUnsold(detail.getTotalProducts() - detail.getTotalSold());
			detail.setTotalRevenue(revenueByCategory.getOrDefault(category, 0.0));
			detail.setTotalBids(bidsByCategory.getOrDefault(category, 0L));
			details.add(detail);
		}

		CategoryAnalyticsResponse response = new CategoryAnalyticsResponse();
		response.setProductsByCategory(productsByCategory);
		response.setSoldByCategory(soldByCategory);
		response.setRevenueByCategory(revenueByCategory);
		response.setBidsByCategory(bidsByCategory);
		response.setCategoryDetails(details);

		return response;
	}
}
