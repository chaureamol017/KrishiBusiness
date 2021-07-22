package com.mycomp.business.krishi.service.api.model;

public class ProductPriceModel {
    private Long productPriceId;
    private Long productId;
    private Long minimumPrice;
    private Long maximumPrice;

	public Long getProductPriceId() {
		return productPriceId;
	}
	public void setProductPriceId(Long productPriceId) {
		this.productPriceId = productPriceId;
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
}
