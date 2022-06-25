package com.mycomp.krishi.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "farmer_product_bid")
public class FarmerProductBid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "farmer_product_bid_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmerProductBidId;

    @Column(name = "farmer_product_id")
    private Long farmerProductId;

    @Column(name = "buyer_user_id")
    private Long buyerUserId;

    @Column(name = "bidding_rate")
    private String biddingRate;
    
	@Column(name = "bid_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date bidOn;

    @Column(name = "accepted")
    private boolean accepted;

	@Column(name = "accepted_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date acceptedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_product_id", insertable = false, updatable = false)
    private Product farmerProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_user_id", insertable = false, updatable = false)
    private User buyerUser;

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

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public Date getAcceptedOn() {
		return acceptedOn;
	}

	public void setAcceptedOn(Date acceptedOn) {
		this.acceptedOn = acceptedOn;
	}

	public Product getFarmerProduct() {
		return farmerProduct;
	}

	public void setFarmerProduct(Product farmerProduct) {
		this.farmerProduct = farmerProduct;
	}

	public User getBuyerUser() {
		return buyerUser;
	}

	public void setBuyerUser(User buyerUser) {
		this.buyerUser = buyerUser;
	}
}
