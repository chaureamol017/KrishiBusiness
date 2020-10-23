/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Rahul
 */
@Entity
@Table(name = "product")
@Setter
@Getter
public class Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "product_id")
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_category_id")
    private String productCategoryId;
    @Column(name = "product_grade_id")
    private String productGradeId;
    @Column(name = "description")
    private String description;
    @Column(name = "city")
    private String city;
    @Column(name = "selling_rate")
    private String sellingRate;
    @Column(name = "product_quanity")
    private int productQuanity;
    @ManyToOne
    @JoinColumn(name = "user")
    private User farmer;
    @JoinColumn(name = "sold_success")
    private boolean soldSuccess;


//    public String getProductId() {
//        return productId;
//    }
//
//    public void setProductId(String productId) {
//        this.productId = productId;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public String getProductCategoryId() {
//        return productCategoryId;
//    }
//
//    public void setProductCategoryId(String productCategoryId) {
//        this.productCategoryId = productCategoryId;
//    }
//
//    public String getProductGradeId() {
//        return productGradeId;
//    }
//
//    public void setProductGradeId(String productGradeId) {
//        this.productGradeId = productGradeId;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getSellingRate() {
//        return sellingRate;
//    }
//
//    public void setSellingRate(String sellingRate) {
//        this.sellingRate = sellingRate;
//    }
//
//    public User getFarmer() {
//        return farmer;
//    }
//
//    public void setFarmer(User farmer) {
//        this.farmer = farmer;
//    }
}
