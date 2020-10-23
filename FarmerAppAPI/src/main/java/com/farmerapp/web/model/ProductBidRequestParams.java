/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.web.model;

/**
 *
 * @author Amol
 */
public class ProductBidRequestParams {
    private String productBidId;
    private String buyerId;
    private String productId;
    private String biddingRate;

    public String getProductBidId() {
        return productBidId;
    }

    public void setProductBidId(String productBidId) {
        this.productBidId = productBidId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBiddingRate() {
        return biddingRate;
    }

    public void setBiddingRate(String biddingRate) {
        this.biddingRate = biddingRate;
    }
}
