/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mycomp.krishi.persistence.entity.type.ProductCategory;

/**
 *
 * @author Amol
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(name = "product_name")
	private String productName;

	@Column(name = "description")
	private String description;
	
	@Column(name = "product_category")
    @Enumerated(EnumType.STRING)
	private ProductCategory productCategory;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	
}
