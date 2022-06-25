package com.mycomp.krishi.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_price")
public class ProductPrice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "product_price_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productPriceId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "minimum_price")
    private Long minimumPrice;

    @Column(name = "maximum_price")
    private Long maximumPrice;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
