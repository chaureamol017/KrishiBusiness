package com.mycomp.krishi.web.v1.model;

import java.util.Date;

public class FarmerProductBidRequest {

	private Long farmerProductBidId;
	private Long farmerProductId;
	private Long buyerUserId;
	private double quotedPricePerUnit;
	private Date bidOn;
	private Date acceptedOn;
	private Boolean accepted;

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

	public double getQuotedPricePerUnit() {
		return quotedPricePerUnit;
	}

	public void setQuotedPricePerUnit(double quotedPricePerUnit) {
		this.quotedPricePerUnit = quotedPricePerUnit;
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

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

}

