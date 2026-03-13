package com.mycomp.krishi.web.v1.model;

public class AdminReportResponse {
	private long totalUsers;
	private long totalProducts;
	private long totalFarmerProducts;
	private long totalFarmerProductsSold;
	private long totalFarmerProductsUnsold;
	private long totalBids;
	private long totalAcceptedBids;
	private double platformTotalRevenue;

	public long getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}

	public long getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(long totalProducts) {
		this.totalProducts = totalProducts;
	}

	public long getTotalFarmerProducts() {
		return totalFarmerProducts;
	}

	public void setTotalFarmerProducts(long totalFarmerProducts) {
		this.totalFarmerProducts = totalFarmerProducts;
	}

	public long getTotalFarmerProductsSold() {
		return totalFarmerProductsSold;
	}

	public void setTotalFarmerProductsSold(long totalFarmerProductsSold) {
		this.totalFarmerProductsSold = totalFarmerProductsSold;
	}

	public long getTotalFarmerProductsUnsold() {
		return totalFarmerProductsUnsold;
	}

	public void setTotalFarmerProductsUnsold(long totalFarmerProductsUnsold) {
		this.totalFarmerProductsUnsold = totalFarmerProductsUnsold;
	}

	public long getTotalBids() {
		return totalBids;
	}

	public void setTotalBids(long totalBids) {
		this.totalBids = totalBids;
	}

	public long getTotalAcceptedBids() {
		return totalAcceptedBids;
	}

	public void setTotalAcceptedBids(long totalAcceptedBids) {
		this.totalAcceptedBids = totalAcceptedBids;
	}

	public double getPlatformTotalRevenue() {
		return platformTotalRevenue;
	}

	public void setPlatformTotalRevenue(double platformTotalRevenue) {
		this.platformTotalRevenue = platformTotalRevenue;
	}
}
