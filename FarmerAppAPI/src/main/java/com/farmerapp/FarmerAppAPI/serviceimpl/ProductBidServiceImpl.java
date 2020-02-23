/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.FarmerAppAPI.serviceimpl;

import com.common.operations.CommonUtils;
import com.farmerapp.FarmerAppAPI.dao.ProductBidDao;
import com.farmerapp.FarmerAppAPI.entity.Product;
import com.farmerapp.FarmerAppAPI.entity.ProductBid;
import com.farmerapp.FarmerAppAPI.entity.User;
import com.farmerapp.FarmerAppAPI.entity.params.ProductBidRequestParams;
import com.farmerapp.FarmerAppAPI.service.ProductBidService;
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
 * @author Amol
 */
@Service
public class ProductBidServiceImpl implements ProductBidService {

    @Autowired
    private ProductBidDao productBidDaoObj;
    @Autowired
    private ProductService productServiceObj;
    @Autowired
    private UserService userServiceObj;

    @Override
    public ApiResponse saveProductBid(ProductBidRequestParams requestParams) {
        ApiResponse apiResponse = new ApiResponse();
        String productBidId = requestParams.getProductBidId();
        String biddingRate = requestParams.getBiddingRate();

        ProductBid productBid = null;
        if (!CommonUtils.isNullOrEmpty(productBidId)) {
            productBid = productBidDaoObj.getOne(productBidId);
        }
        if (CommonUtils.checkIfNull(productBid)) {
            productBid = new ProductBid();
            String userId = requestParams.getBuyerId();
            String productId = requestParams.getProductId();
            User user = userServiceObj.getUser(userId);
            Product product = productServiceObj.getProduct(productId);
            productBid.setBuyer(user);
            productBid.setProductId(product);
        }
        productBid.setBiddingRate(biddingRate);

        productBid = productBidDaoObj.saveAndFlush(productBid);
        JSONObject responseJson = populateProductBid(productBid);

        apiResponse.setData(responseJson.toString());
        apiResponse.setSuccess(true);

        return apiResponse;
    }

    @Override
    public ApiResponse acceptProductBid(ProductBidRequestParams requestParams) {
        ApiResponse apiResponse = new ApiResponse();
        JSONObject responseJson = new JSONObject();

        String productId = requestParams.getProductId();
        List<ProductBid> productBidList = getProductBidListByUserAndProduct(productId);
        if (CommonUtils.checkIfListNotEmpty(productBidList)) {
            String productBidId = requestParams.getProductBidId();
            ProductBid productBid = null;
            for (ProductBid pb : productBidList) {
                if (productBid.getProductBidId().equals(productBidId)) {
                    productBidList.remove(pb);
                    productBid = pb;
                    break;
                }
            }
            if (CommonUtils.checkIfNotNull(productBid)) {
                responseJson = acceptProductBid(productBid);
            }
            if (CommonUtils.checkIfListNotEmpty(productBidList)) {
                productBidDaoObj.deleteInBatch(productBidList);
            }

        }

        apiResponse.setData(responseJson.toString());
        apiResponse.setSuccess(true);

        return apiResponse;
    }

    public JSONObject acceptProductBid(ProductBid productBid) {
        JSONObject responseJson = new JSONObject();

        Product product = productBid.getProductId();
        productServiceObj.soldProduct(product);

        productBid.setAcceptedBidding(Boolean.TRUE);
        productBidDaoObj.saveAndFlush(productBid);
        return responseJson;
    }

    @Override
    public JSONObject updateProductBid(JSONObject requestBodyJson) {
        String productBidId = (String) requestBodyJson.get("productBidId");
        String biddingRate = (String) requestBodyJson.get("biddingRate");
        ProductBid productBid = getProductBidNonFormated(productBidId);
        if (CommonUtils.checkIfNotNull(productBid)) {
            productBid.setBiddingRate(biddingRate);

            productBid = productBidDaoObj.saveAndFlush(productBid);
        }

        return populateProductBid(productBid);
    }

    @Override
    public JSONObject getAllProductBids() {
        List<ProductBid> productBidList = productBidDaoObj.findAll();

        JSONArray dataJsonArr = populateProductBidDataInJson(productBidList);
        JSONObject responseJson = new JSONObject();
        
        responseJson.put("data", dataJsonArr);

        return responseJson;
    }

    @Override
    public ProductBid getProductBidNonFormated(String productBidId) {
        return productBidDaoObj.getOne(productBidId);
    }

    @Override
    public JSONObject getProductBid(String productBidId) {
        ProductBid productBid = getProductBidNonFormated(productBidId);
        return populateProductBid(productBid);
    }

    @Override
    public ApiResponse getProductBidByUserAndSellingStatus(String productId, String userId) {
        ApiResponse apiResponse = new ApiResponse();
        List<ProductBid> productBidList = getProductBidListByUserAndProduct(productId);
//        Number num = productBidDaoObj.getProductBidCountByUser(productId);

        JSONArray dataJsonArr =  populateProductBidDataInJson(productBidList);
        
        apiResponse.setData(dataJsonArr.toString());
        apiResponse.setSuccess(true);

        return apiResponse;
    }

    @Override
    public ApiResponse deleteProductBid(String productBidId) {
        ApiResponse apiResponse = new ApiResponse();
        productBidDaoObj.deleteById(productBidId);
        
        apiResponse.setSuccess(true);
        JSONObject jObj = new JSONObject();
        jObj.put("message",  "Bid rejected");
        
        apiResponse.setData(jObj.toString());
        
        return apiResponse;
    }

    private List<ProductBid> getProductBidListByUserAndProduct(String productId) {
        List<ProductBid> productBidList = productBidDaoObj.getProductBidByProduct(productId);

        return productBidList;
    }

    private JSONArray populateProductBidDataInJson(List<ProductBid> productBidList) {
        JSONArray dataJsonArr = new JSONArray();
        if (CommonUtils.checkIfListNotEmpty(productBidList)) {

            productBidList.stream()
                    .filter(productBid -> CommonUtils.checkIfNotNull(productBid))
                    .forEach(productBid
                            -> dataJsonArr.put(populateProductBid(productBid))
                    );

        }
        return dataJsonArr;
    }

    private JSONObject populateProductBid(ProductBid productBid) {
        JSONObject detailsJson = new JSONObject();

        if (CommonUtils.checkIfNotNull(productBid)) {
            Product productObj = productBid.getProductId();
            User userObj = productBid.getBuyer();
            String biddingRate = productBid.getBiddingRate();

            userServiceObj.populatUserJsonAsBuyer(userObj, detailsJson);
            productServiceObj.populateProduct(productObj, detailsJson);
            detailsJson.put("biddingRate", biddingRate);
        }

        return detailsJson;
    }
}
