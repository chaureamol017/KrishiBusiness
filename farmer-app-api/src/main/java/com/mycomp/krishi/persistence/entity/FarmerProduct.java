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
@Table(name = "farmer_product")
public class FarmerProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "farmer_product_id")
	private Long farmerProductId;
	@Column(name = "product_id")
	private Long productId;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "quantity")
	private double quantity;
	@Column(name = "quantity_unit")
	private String quantityUnit;
	@Column(name = "price_per_unit")
	private double pricePerUnit;
	@Column(name = "expected_price_per_unit")
	private double expectedPricePerUnit;
	@Column(name = "added_on")
	private Date addedOn;
	@Column(name = "sold_on")
	private Date soldOn;
	@Column(name = "sold")
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

	public Boolean getSold() {
		return sold;
	}

	public void setSold(Boolean sold) {
		this.sold = sold;
	}

}

