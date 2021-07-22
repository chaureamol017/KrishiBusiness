package com.mycomp.business.krishi.service.api.model;

import java.util.Date;

public class FarmerProductBuyerMapModel {

    private Long farmerProductBuyerMapId;
    private Long farmerProductId;
    private Long buyerUserId;
	private Long soldPrice;
	private Date soldOn;
	
	public Long getFarmerProductBuyerMapId() {
		return farmerProductBuyerMapId;
	}
	public void setFarmerProductBuyerMapId(Long farmerProductBuyerMapId) {
		this.farmerProductBuyerMapId = farmerProductBuyerMapId;
	}
	public Long getFarmerProductId() {
		return farmerProductId;
	}
	public void setFarmerProductId(Long farmerProductId) {
		this.farmerProductId = farmerProductId;
	}
	public Long getBuyerUserId() {
		return buyerUserId;
	}
	public void setBuyerUserId(Long buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
	public Long getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(Long soldPrice) {
		this.soldPrice = soldPrice;
	}
	public Date getSoldOn() {
		return soldOn;
	}
	public void setSoldOn(Date soldOn) {
		this.soldOn = soldOn;
	}
}
