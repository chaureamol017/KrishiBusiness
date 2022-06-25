package com.mycomp.krishi.web.v1.model;

import java.sql.Timestamp;

public class FarmerProductWeb {
    private Long farmerProductId;
    private Long productId;
    private Long userId;
	private int productQuantity;
	private Long expectedPrice;
	private Timestamp addedOn;
	private boolean sold;
	private Timestamp soldOn;

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

	public Timestamp getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}

	public Timestamp getSoldOn() {
		return soldOn;
	}

	public void setSoldOn(Timestamp soldOn) {
		this.soldOn = soldOn;
	}
}
