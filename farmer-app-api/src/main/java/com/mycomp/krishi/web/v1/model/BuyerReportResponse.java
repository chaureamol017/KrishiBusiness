package com.mycomp.krishi.web.v1.model;

import java.util.List;

public class BuyerReportResponse {
	private long totalBidsPlaced;
	private long totalBidsAccepted;
	private long totalBidsPending;
	private double totalAmountSpent;
	private double averageQuotedPrice;
	private List<BidDetail> bidDetails;

	public long getTotalBidsPlaced() {
		return totalBidsPlaced;
	}

	public void setTotalBidsPlaced(long totalBidsPlaced) {
		this.totalBidsPlaced = totalBidsPlaced;
	}

	public long getTotalBidsAccepted() {
		return totalBidsAccepted;
	}

	public void setTotalBidsAccepted(long totalBidsAccepted) {
		this.totalBidsAccepted = totalBidsAccepted;
	}

	public long getTotalBidsPending() {
		return totalBidsPending;
	}

	public void setTotalBidsPending(long totalBidsPending) {
		this.totalBidsPending = totalBidsPending;
	}

	public double getTotalAmountSpent() {
		return totalAmountSpent;
	}

	public void setTotalAmountSpent(double totalAmountSpent) {
		this.totalAmountSpent = totalAmountSpent;
	}

	public double getAverageQuotedPrice() {
		return averageQuotedPrice;
	}

	public void setAverageQuotedPrice(double averageQuotedPrice) {
		this.averageQuotedPrice = averageQuotedPrice;
	}

	public List<BidDetail> getBidDetails() {
		return bidDetails;
	}

	public void setBidDetails(List<BidDetail> bidDetails) {
		this.bidDetails = bidDetails;
	}

	public static class BidDetail {
		private Long farmerProductId;
		private String productName;
		private String category;
		private double quotedPricePerUnit;
		private String bidOn;
		private String acceptedOn;
		private boolean accepted;

		public Long getFarmerProductId() {
			return farmerProductId;
		}

		public void setFarmerProductId(Long farmerProductId) {
			this.farmerProductId = farmerProductId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public double getQuotedPricePerUnit() {
			return quotedPricePerUnit;
		}

		public void setQuotedPricePerUnit(double quotedPricePerUnit) {
			this.quotedPricePerUnit = quotedPricePerUnit;
		}

		public String getBidOn() {
			return bidOn;
		}

		public void setBidOn(String bidOn) {
			this.bidOn = bidOn;
		}

		public String getAcceptedOn() {
			return acceptedOn;
		}

		public void setAcceptedOn(String acceptedOn) {
			this.acceptedOn = acceptedOn;
		}

		public boolean isAccepted() {
			return accepted;
		}

		public void setAccepted(boolean accepted) {
			this.accepted = accepted;
		}
	}
}
