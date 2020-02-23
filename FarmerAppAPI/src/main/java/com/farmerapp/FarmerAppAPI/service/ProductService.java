/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.FarmerAppAPI.service;

import com.farmerapp.FarmerAppAPI.entity.Product;
import com.farmerapp.FarmerAppAPI.entity.params.ProductRequestParams;
import com.farmerapp.common.implementation.response.ApiResponse;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Rahul
 */
public interface ProductService {

    ApiResponse saveProduct(ProductRequestParams requestParams);

    ApiResponse updateProduct(ProductRequestParams requestParams);
    
    public Product soldProduct(Product product);

    List<Product> getAllProductList();

    Product getProduct(String productId);

    public List<Product> findProductByName(String productName);

    public ApiResponse findAllUnsoldProducts();
    
    public ApiResponse findProductByUser(String userId, boolean isSold);

    List<Product> getProductByJPQ();

    List<Product> getProductByNativeQuery();

    ApiResponse deleteProduct(String id);

    public JSONObject populateProduct(Product product);

    public JSONObject populateProduct(Product product, JSONObject detailsSson);
}
