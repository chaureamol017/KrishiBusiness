package com.mycomp.krishi.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farmer_product_bid")
public class FarmerProductBid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "farmer_product_bid_id")
	private Long farmerProductBidId;
	@Column(name = "farmer_product_id")
	private Long farmerProductId;
	@Column(name = "buyer_user_id")
	private Long buyerUserId;
	@Column(name = "quoted_price_per_unit")
	private double quotedPricePerUnit;
	@Column(name = "bid_on")
	private Date bidOn;
	@Column(name = "accepted_on")
	private Date acceptedOn;
	@Column(name = "accepted")
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

	public Boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

}

