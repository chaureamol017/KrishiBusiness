package com.mycomp.krishi.web.v1.model;

import java.util.List;

public class SellerReportResponse {
	private long totalProductsListed;
	private long totalProductsSold;
	private long totalProductsUnsold;
	private double totalRevenue;
	private double averagePricePerUnit;
	private List<ProductSalesDetail> productSalesDetails;

	public long getTotalProductsListed() {
		return totalProductsListed;
	}

	public void setTotalProductsListed(long totalProductsListed) {
		this.totalProductsListed = totalProductsListed;
	}

	public long getTotalProductsSold() {
		return totalProductsSold;
	}

	public void setTotalProductsSold(long totalProductsSold) {
		this.totalProductsSold = totalProductsSold;
	}

	public long getTotalProductsUnsold() {
		return totalProductsUnsold;
	}

	public void setTotalProductsUnsold(long totalProductsUnsold) {
		this.totalProductsUnsold = totalProductsUnsold;
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public double getAveragePricePerUnit() {
		return averagePricePerUnit;
	}

	public void setAveragePricePerUnit(double averagePricePerUnit) {
		this.averagePricePerUnit = averagePricePerUnit;
	}

	public List<ProductSalesDetail> getProductSalesDetails() {
		return productSalesDetails;
	}

	public void setProductSalesDetails(List<ProductSalesDetail> productSalesDetails) {
		this.productSalesDetails = productSalesDetails;
	}

	public static class ProductSalesDetail {
		private String productName;
		private String category;
		private double quantity;
		private String quantityUnit;
		private double pricePerUnit;
		private String city;
		private String addedOn;
		private String soldOn;
		private boolean sold;
		private double totalValue;

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

		public double getQuantity() {
			return quantity;
		}

		public void setQuantity(double quantity) {
			this.quantity = quantity;
		}

		public String getQuantityUnit() {
			return quantityUnit;
		}

		public void setQuantityUnit(String quantityUnit) {
			this.quantityUnit = quantityUnit;
		}

		public double getPricePerUnit() {
			return pricePerUnit;
		}

		public void setPricePerUnit(double pricePerUnit) {
			this.pricePerUnit = pricePerUnit;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getAddedOn() {
			return addedOn;
		}

		public void setAddedOn(String addedOn) {
			this.addedOn = addedOn;
		}

		public String getSoldOn() {
			return soldOn;
		}

		public void setSoldOn(String soldOn) {
			this.soldOn = soldOn;
		}

		public boolean isSold() {
			return sold;
		}

		public void setSold(boolean sold) {
			this.sold = sold;
		}

		public double getTotalValue() {
			return totalValue;
		}

		public void setTotalValue(double totalValue) {
			this.totalValue = totalValue;
		}
	}
}
