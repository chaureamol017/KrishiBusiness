/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.controller;

import com.farmerapp.common.response.ApiResponse;
import com.farmerapp.service.api.product.ProductBidService;
import com.farmerapp.web.model.ProductBidRequestParams;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Amol
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("productbid")
public class ProductBidController {

    @Autowired
    private ProductBidService productBidServiceObj;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save(@RequestBody ProductBidRequestParams requestParams) {
        ApiResponse apiResponse = productBidServiceObj.saveProductBid(requestParams);
        if (apiResponse != null) {
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/accept")
    public ResponseEntity<ApiResponse> acceptProductBid(@RequestBody ProductBidRequestParams requestBodyJson) {
        ApiResponse productBidJson = productBidServiceObj.acceptProductBid(requestBodyJson);
        if (productBidJson != null) {
            return new ResponseEntity<>(productBidJson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(productBidJson, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<JSONObject> getAllProductBids() {
        JSONObject responseJson = productBidServiceObj.getAllProductBids();
        if (responseJson != null) {
            return new ResponseEntity<>(responseJson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseJson, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/byid")
    public ResponseEntity<JSONObject> getProductBid(@RequestParam(name = "id") String id) {
        JSONObject  responseJson = productBidServiceObj.getProductBid(id);
        if (responseJson != null) {
            return new ResponseEntity<>(responseJson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseJson, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/byuserandproduct")
    public ResponseEntity<ApiResponse> getProductBidByUserAndProduct(@RequestParam(name = "productId") String productId,@RequestParam(name = "userId") String userId) {
        ApiResponse responseJson = productBidServiceObj.getProductBidByUserAndSellingStatus(userId, productId);
        if (responseJson != null) {
            return new ResponseEntity<>(responseJson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseJson, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteProductBid(@RequestParam(name = "id") String id) {
        ApiResponse responseJson = productBidServiceObj.deleteProductBid(id);
        if (responseJson != null) {
            return new ResponseEntity<>(responseJson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseJson, HttpStatus.NOT_FOUND);
        }
    }
}
