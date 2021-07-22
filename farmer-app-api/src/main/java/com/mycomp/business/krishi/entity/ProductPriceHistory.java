package com.mycomp.business.krishi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product_price_history")
public class ProductPriceHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_price_history_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productPriceHistoryId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "minimum_price")
    private Long minimumPrice;

    @Column(name = "maximum_price")
    private Long maximumPrice;

	@Column(name = "price_on")
	@Temporal(TemporalType.DATE)
	private Date priceOn;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
