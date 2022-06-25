/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.web.v1.model;

/**
 *
 * @author Amol
 */
public class ProductRequestParams {
    private String productId;
    private String userId;
    private String productName;
    private String productCategoryId;
    private String productGradeId;
    private String description;
    private String city;
    private String sellingRate;
    private int productQuanity;
    private boolean soldSuccess;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductGradeId() {
        return productGradeId;
    }

    public void setProductGradeId(String productGradeId) {
        this.productGradeId = productGradeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(String sellingRate) {
        this.sellingRate = sellingRate;
    }

    public int getProductQuanity() {
        return productQuanity;
    }

    public void setProductQuanity(int productQuanity) {
        this.productQuanity = productQuanity;
    }

    public boolean isSoldSuccess() {
        return soldSuccess;
    }

    public void setSoldSuccess(boolean soldSuccess) {
        this.soldSuccess = soldSuccess;
    }
    
    
}
