package com.mycomp.business.krishi.service.api.model;

import java.util.Date;

public class FarmerProductBidModel {
    private Long farmerProductBidId;
    private Long farmerProductId;
    private Long buyerUserId;
    private String biddingRate;
	private Date bidOn;
	private Date acceptedOn;
    private boolean accepted;

	public Long getFarmerProductBidId() {
		return farmerProductBidId;
	}
	public void setFarmerProductBidId(Long farmerProductBidId) {
		this.farmerProductBidId = farmerProductBidId;
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
	public String getBiddingRate() {
		return biddingRate;
	}
	public void setBiddingRate(String biddingRate) {
		this.biddingRate = biddingRate;
	}
	public Date getBidOn() {
		return bidOn;
	}
	public void setBidOn(Date bidOn) {
		this.bidOn = bidOn;
	}
	public Date getAcceptedOn() {
		return acceptedOn;
	}
	public void setAcceptedOn(Date acceptedOn) {
		this.acceptedOn = acceptedOn;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
}
