package com.mycomp.business.krishi.service.api.model;

import java.util.Date;

public class ProductPriceHistoryModel {
    private Long productPriceHistoryId;
    private Long productId;
    private Long minimumPrice;
    private Long maximumPrice;
    private Date priceOn;

	public Long getProductPriceHistoryId() {
		return productPriceHistoryId;
	}
	public void setProductPriceHistoryId(Long productPriceHistoryId) {
		this.productPriceHistoryId = productPriceHistoryId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getMinimumPrice() {
		return minimumPrice;
	}
	public void setMinimumPrice(Long minimumPrice) {
		this.minimumPrice = minimumPrice;
	}
	public Long getMaximumPrice() {
		return maximumPrice;
	}
	public void setMaximumPrice(Long maximumPrice) {
		this.maximumPrice = maximumPrice;
	}
	public Date getPriceOn() {
		return priceOn;
	}
	public void setPriceOn(Date priceOn) {
		this.priceOn = priceOn;
	}
	
}
