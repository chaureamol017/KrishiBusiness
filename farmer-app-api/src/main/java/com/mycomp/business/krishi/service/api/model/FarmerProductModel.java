package com.mycomp.business.krishi.service.api.model;

import java.util.Date;

public class FarmerProductModel {
    private Long farmerProductId;
    private Long productId;
    private Long userId;
	private int productQuantity;
	private Long expectedPrice;
	private Date addedOn;
	private boolean sold;
	private Date soldOn;

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

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Long getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(Long expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
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
}
