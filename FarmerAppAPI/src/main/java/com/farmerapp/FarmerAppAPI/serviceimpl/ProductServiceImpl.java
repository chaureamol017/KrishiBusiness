/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.FarmerAppAPI.serviceimpl;

import com.common.operations.CommonUtils;
import com.farmerapp.FarmerAppAPI.dao.ProductDao;
import com.farmerapp.FarmerAppAPI.entity.Product;
import com.farmerapp.FarmerAppAPI.entity.User;
import com.farmerapp.FarmerAppAPI.entity.params.ProductRequestParams;
import com.farmerapp.FarmerAppAPI.service.ProductService;
import com.farmerapp.FarmerAppAPI.service.UserService;
import com.farmerapp.common.implementation.response.ApiResponse;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rahul
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDaoObj;
    @Autowired
    private UserService userServiceObj;

    @Override
    public ApiResponse saveProduct(ProductRequestParams requestParams) {
        ApiResponse apiResponse = new ApiResponse();

        String userId = requestParams.getUserId();
        String productName = requestParams.getProductName();
        String productCategoryId = requestParams.getProductCategoryId();
        String productGradeId = requestParams.getProductGradeId();
        String description = requestParams.getDescription();
        String city = requestParams.getCity();
        String sellingRate = requestParams.getSellingRate();
        int productQuantity = requestParams.getProductQuanity();

        User user = userServiceObj.getUser(userId);

        Product product = new Product();

        product.setProductName(productName);
        product.setProductCategoryId(productCategoryId);
        product.setProductGradeId(productGradeId);
        product.setDescription(description);
        product.setCity(city);
        product.setSellingRate(sellingRate);
        product.setProductQuanity(productQuantity);
        product.setFarmer(user);

        productDaoObj.save(product);

        JSONObject detailsJson = populateProduct(product);

        apiResponse.setSuccess(true);
        apiResponse.setData(detailsJson.toString());

        return apiResponse;
    }

    @Override
    public ApiResponse updateProduct(ProductRequestParams requestParams) {
        ApiResponse apiResponse = new ApiResponse();

        String productId = requestParams.getProductId();
        String productName = requestParams.getProductName();
        String productCategoryId = requestParams.getProductCategoryId();
        String productGradeId = requestParams.getProductGradeId();
        String description = requestParams.getDescription();
        String city = requestParams.getCity();
        String sellingRate = requestParams.getSellingRate();

        Product product = null;

        if (!CommonUtils.isNullOrEmpty(productId)) {
            product = getProduct(productId);
        }
        if (CommonUtils.checkIfNull(product)) {
            String userId = requestParams.getUserId();
            User user = userServiceObj.getUser(userId);
            product = new Product();
            product.setFarmer(user);
        }

        product.setProductName(productName);
        product.setProductCategoryId(productCategoryId);
        product.setProductGradeId(productGradeId);
        product.setDescription(description);
        product.setCity(city);
        product.setSellingRate(sellingRate);

        productDaoObj.saveAndFlush(product);

        JSONObject detailsJson = populateProduct(product);

        apiResponse.setSuccess(true);
        apiResponse.setData(detailsJson.toString());

        return apiResponse;
    }

    public Product updateProduct(Product product) {
        return productDaoObj.saveAndFlush(product);
    }

    @Override
    public Product soldProduct(Product product) {
        product.setSoldSuccess(Boolean.TRUE);

        return productDaoObj.saveAndFlush(product);
    }

    @Override
    public List<Product> getAllProductList() {
        return productDaoObj.findAll();
    }

    @Override
    public Product getProduct(String productId) {
        return productDaoObj.getOne(productId);
    }

    @Override
    public List<Product> findProductByName(String productName) {
        return productDaoObj.findProductByName(productName);
    }

    @Override
    public ApiResponse findAllUnsoldProducts() {
        ApiResponse apiResponse = new ApiResponse();
        List<Product> productList = productDaoObj.findAllProductsBySoldStatus(false);
//        Number num = productDaoObj.getProductCountByUser(userId);

        JSONArray dataJsonArr = populateProductDataInJson(productList);
        apiResponse.setSuccess(true);
        apiResponse.setData(dataJsonArr.toString());

        return apiResponse;
    }

    @Override
    public ApiResponse findProductByUser(String userId, boolean isSold) {
        ApiResponse apiResponse = new ApiResponse();
        List<Product> productList = productDaoObj.findProductByUser(userId, isSold);
//        Number num = productDaoObj.getProductCountByUser(userId);

        JSONArray dataJsonArr = populateProductDataInJson(productList);
        apiResponse.setSuccess(true);
        apiResponse.setData(dataJsonArr.toString());

        return apiResponse;
    }

    /**
     * JPQ - JPA query language
     *
     * @return product object
     */
    @Override
    public List<Product> getProductByJPQ() {
        return productDaoObj.getProductByJPQ();
    }

    /**
     * Native Query
     *
     * @return product object
     */
    @Override
    public List<Product> getProductByNativeQuery() {
        return productDaoObj.getProductByNativeQuery();
    }

    @Override
    public ApiResponse deleteProduct(String id) {
        ApiResponse apiRespoonse = new ApiResponse();
        productDaoObj.deleteById(id);

        apiRespoonse.setSuccess(true);

        return apiRespoonse;
    }

    public JSONArray populateProductDataInJson(List<Product> productList) {
        JSONArray dataJsonArr = new JSONArray();

        if (CommonUtils.checkIfListNotEmpty(productList)) {

            productList.stream()
                    .filter((product) -> CommonUtils.checkIfNotNull(product))
                    .forEach((product) -> {
//                        dataJsonArr.put(this.populateProduct(product));
                        dataJsonArr.put(populateProduct(product));
                    });
        }

        return dataJsonArr;
    }

    @Override
    public JSONObject populateProduct(Product product) {
        JSONObject detailsJson = populateProduct(product, null);

        String productCategoryId = product.getProductCategoryId();
        String productGradeId = product.getProductGradeId();
        String description = product.getDescription();

        User farmer = product.getFarmer();

        userServiceObj.populatUserJson(farmer, detailsJson);
        detailsJson.put("productCategoryId", productCategoryId);
        detailsJson.put("productGradeId", productGradeId);
        detailsJson.put("description", description);

        return detailsJson;
    }

    @Override
    public JSONObject populateProduct(Product product, JSONObject detailsJson) {
        if (!CommonUtils.checkIfNotNull(detailsJson)) {
            detailsJson = new JSONObject();
        }

        if (CommonUtils.checkIfNotNull(product)) {
            String productId = product.getProductId();
            String productName = product.getProductName();
            String city = product.getCity();
            String sellingRate = product.getSellingRate();

            detailsJson.put("productId", productId);
            detailsJson.put("productName", productName);
            detailsJson.put("city", city);
            detailsJson.put("sellingRate", sellingRate);
        }

        return detailsJson;
    }
}
