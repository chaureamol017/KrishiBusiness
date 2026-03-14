package com.mycomp.krishi.web.v1.model;

import java.util.Date;

public class TransactionResponse {
	private Long transactionId;
	private Long farmerProductId;
	private String productName;
	private String category;
	private double quantity;
	private String quantityUnit;
	private double pricePerUnit;
	private double totalAmount;
	private String city;
	private Long sellerUserId;
	private String sellerName;
	private Long buyerUserId;
	private String buyerName;
	private double quotedPricePerUnit;
	private Date soldOn;
	private Date bidAcceptedOn;

	public Long getTransactionId() { return transactionId; }
	public void setTransactionId(Long transactionId) { this.transactionId = transactionId; }

	public Long getFarmerProductId() { return farmerProductId; }
	public void setFarmerProductId(Long farmerProductId) { this.farmerProductId = farmerProductId; }

	public String getProductName() { return productName; }
	public void setProductName(String productName) { this.productName = productName; }

	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }

	public double getQuantity() { return quantity; }
	public void setQuantity(double quantity) { this.quantity = quantity; }

	public String getQuantityUnit() { return quantityUnit; }
	public void setQuantityUnit(String quantityUnit) { this.quantityUnit = quantityUnit; }

	public double getPricePerUnit() { return pricePerUnit; }
	public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }

	public double getTotalAmount() { return totalAmount; }
	public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }

	public Long getSellerUserId() { return sellerUserId; }
	public void setSellerUserId(Long sellerUserId) { this.sellerUserId = sellerUserId; }

	public String getSellerName() { return sellerName; }
	public void setSellerName(String sellerName) { this.sellerName = sellerName; }

	public Long getBuyerUserId() { return buyerUserId; }
	public void setBuyerUserId(Long buyerUserId) { this.buyerUserId = buyerUserId; }

	public String getBuyerName() { return buyerName; }
	public void setBuyerName(String buyerName) { this.buyerName = buyerName; }

	public double getQuotedPricePerUnit() { return quotedPricePerUnit; }
	public void setQuotedPricePerUnit(double quotedPricePerUnit) { this.quotedPricePerUnit = quotedPricePerUnit; }

	public Date getSoldOn() { return soldOn; }
	public void setSoldOn(Date soldOn) { this.soldOn = soldOn; }

	public Date getBidAcceptedOn() { return bidAcceptedOn; }
	public void setBidAcceptedOn(Date bidAcceptedOn) { this.bidAcceptedOn = bidAcceptedOn; }
}
