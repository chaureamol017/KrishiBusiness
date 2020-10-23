/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.service.api.product;

import com.farmerapp.common.response.ApiResponse;
import com.farmerapp.entity.ProductBid;
import com.farmerapp.web.model.ProductBidRequestParams;

import org.json.JSONObject;

/**
 *
 * @author Amol
 */
public interface ProductBidService {

    public ApiResponse saveProductBid(ProductBidRequestParams requestParams);

    public ApiResponse acceptProductBid(ProductBidRequestParams requestParams);

    public JSONObject updateProductBid(JSONObject requestBodyJson);

    public JSONObject getAllProductBids();

    public ProductBid getProductBidNonFormated(String productBidId);

    public JSONObject getProductBid(String productBidId);

    public ApiResponse getProductBidByUserAndSellingStatus(String productId, String userId);

    public ApiResponse deleteProductBid(String id);

}
