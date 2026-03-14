package com.mycomp.krishi.web.v1.model;

import java.util.List;
import java.util.Map;

public class CategoryAnalyticsResponse {
	private Map<String, Long> productsByCategory;
	private Map<String, Long> soldByCategory;
	private Map<String, Double> revenueByCategory;
	private Map<String, Long> bidsByCategory;
	private List<CategoryDetail> categoryDetails;

	public Map<String, Long> getProductsByCategory() { return productsByCategory; }
	public void setProductsByCategory(Map<String, Long> productsByCategory) { this.productsByCategory = productsByCategory; }

	public Map<String, Long> getSoldByCategory() { return soldByCategory; }
	public void setSoldByCategory(Map<String, Long> soldByCategory) { this.soldByCategory = soldByCategory; }

	public Map<String, Double> getRevenueByCategory() { return revenueByCategory; }
	public void setRevenueByCategory(Map<String, Double> revenueByCategory) { this.revenueByCategory = revenueByCategory; }

	public Map<String, Long> getBidsByCategory() { return bidsByCategory; }
	public void setBidsByCategory(Map<String, Long> bidsByCategory) { this.bidsByCategory = bidsByCategory; }

	public List<CategoryDetail> getCategoryDetails() { return categoryDetails; }
	public void setCategoryDetails(List<CategoryDetail> categoryDetails) { this.categoryDetails = categoryDetails; }

	public static class CategoryDetail {
		private String category;
		private long totalProducts;
		private long totalSold;
		private long totalUnsold;
		private double totalRevenue;
		private long totalBids;

		public String getCategory() { return category; }
		public void setCategory(String category) { this.category = category; }

		public long getTotalProducts() { return totalProducts; }
		public void setTotalProducts(long totalProducts) { this.totalProducts = totalProducts; }

		public long getTotalSold() { return totalSold; }
		public void setTotalSold(long totalSold) { this.totalSold = totalSold; }

		public long getTotalUnsold() { return totalUnsold; }
		public void setTotalUnsold(long totalUnsold) { this.totalUnsold = totalUnsold; }

		public double getTotalRevenue() { return totalRevenue; }
		public void setTotalRevenue(double totalRevenue) { this.totalRevenue = totalRevenue; }

		public long getTotalBids() { return totalBids; }
		public void setTotalBids(long totalBids) { this.totalBids = totalBids; }
	}
}
