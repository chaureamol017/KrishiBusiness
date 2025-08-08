package com.mycomp.krishi.web.v1.model;

import java.util.Date;

public class FarmerProductRequest {

	private Long farmerProductId;
	private Long productId;
	private Long userId;
	private String description;
	private double quantity;
	private String quantityUnit;
	private double pricePerUnit;
	private double expectedPricePerUnit;
	private String city;
	private Date addedOn;
	private Date soldOn;
	private Boolean sold;

	public Long getFarmerProductId() {
		return farmerProductId;
	}

	public void setFarmerProductId(Long farmerProductId) {
		this.farmerProductId = farmerProductId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public double getExpectedPricePerUnit() {
		return expectedPricePerUnit;
	}

	public void setExpectedPricePerUnit(double expectedPricePerUnit) {
		this.expectedPricePerUnit = expectedPricePerUnit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public Date getSoldOn() {
		return soldOn;
	}

	public void setSoldOn(Date soldOn) {
		this.soldOn = soldOn;
	}

	public Boolean isSold() {
		return sold;
	}

	public void setSold(Boolean sold) {
		this.sold = sold;
	}

}

