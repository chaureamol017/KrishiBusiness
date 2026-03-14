package com.mycomp.krishi.web.v1.model;

public class DashboardResponse {
    // Common stats
    private String userName;
    private String role;

    // Seller stats
    private Long totalProductsListed;
    private Long totalProductsSold;
    private Long totalProductsUnsold;
    private Double totalRevenue;

    // Buyer stats
    private Long totalBidsPlaced;
    private Long totalBidsAccepted;
    private Long totalBidsPending;
    private Double totalAmountSpent;

    // Admin stats
    private Long totalUsers;
    private Long totalProducts;
    private Long totalFarmerProducts;
    private Long totalFarmerProductsSold;
    private Long totalBids;
    private Long totalAcceptedBids;
    private Double platformTotalRevenue;

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public Long getTotalProductsListed() { return totalProductsListed; }
    public void setTotalProductsListed(Long totalProductsListed) { this.totalProductsListed = totalProductsListed; }
    public Long getTotalProductsSold() { return totalProductsSold; }
    public void setTotalProductsSold(Long totalProductsSold) { this.totalProductsSold = totalProductsSold; }
    public Long getTotalProductsUnsold() { return totalProductsUnsold; }
    public void setTotalProductsUnsold(Long totalProductsUnsold) { this.totalProductsUnsold = totalProductsUnsold; }
    public Double getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(Double totalRevenue) { this.totalRevenue = totalRevenue; }
    public Long getTotalBidsPlaced() { return totalBidsPlaced; }
    public void setTotalBidsPlaced(Long totalBidsPlaced) { this.totalBidsPlaced = totalBidsPlaced; }
    public Long getTotalBidsAccepted() { return totalBidsAccepted; }
    public void setTotalBidsAccepted(Long totalBidsAccepted) { this.totalBidsAccepted = totalBidsAccepted; }
    public Long getTotalBidsPending() { return totalBidsPending; }
    public void setTotalBidsPending(Long totalBidsPending) { this.totalBidsPending = totalBidsPending; }
    public Double getTotalAmountSpent() { return totalAmountSpent; }
    public void setTotalAmountSpent(Double totalAmountSpent) { this.totalAmountSpent = totalAmountSpent; }
    public Long getTotalUsers() { return totalUsers; }
    public void setTotalUsers(Long totalUsers) { this.totalUsers = totalUsers; }
    public Long getTotalProducts() { return totalProducts; }
    public void setTotalProducts(Long totalProducts) { this.totalProducts = totalProducts; }
    public Long getTotalFarmerProducts() { return totalFarmerProducts; }
    public void setTotalFarmerProducts(Long totalFarmerProducts) { this.totalFarmerProducts = totalFarmerProducts; }
    public Long getTotalFarmerProductsSold() { return totalFarmerProductsSold; }
    public void setTotalFarmerProductsSold(Long totalFarmerProductsSold) { this.totalFarmerProductsSold = totalFarmerProductsSold; }
    public Long getTotalBids() { return totalBids; }
    public void setTotalBids(Long totalBids) { this.totalBids = totalBids; }
    public Long getTotalAcceptedBids() { return totalAcceptedBids; }
    public void setTotalAcceptedBids(Long totalAcceptedBids) { this.totalAcceptedBids = totalAcceptedBids; }
    public Double getPlatformTotalRevenue() { return platformTotalRevenue; }
    public void setPlatformTotalRevenue(Double platformTotalRevenue) { this.platformTotalRevenue = platformTotalRevenue; }
}
