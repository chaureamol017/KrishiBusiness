package com.mycomp.business.krishi.entity;

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
@Table(name = "farmer_product_buyer_map")
public class FarmerProductBuyerMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "farmer_product_buyer_map_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmerProductBuyerMapId;

    @Column(name = "farmer_product_id")
    private Long farmerProductId;

    @Column(name = "buyer_user_id")
    private Long buyerUserId;

	@Column(name = "sold_price")
	private Long soldPrice;

	@Column(name = "sold_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date soldOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_product_id", insertable = false, updatable = false)
    private Product farmerProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_user_id", insertable = false, updatable = false)
    private User buyerUser;

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
