/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.web.v1.controller;

import com.mycomp.business.krishi.api.adapter.ResponseEntityAdaptor;
import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.FarmerProductBidService;
import com.mycomp.business.krishi.service.api.model.FarmerProductBidModel;
import com.mycomp.business.krishi.web.v1.adaptor.FarmerProductBidWebAdaptor;
import com.mycomp.business.krishi.web.v1.model.FarmerProductBidWeb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Amol
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/farmer-product-bid")
public class FarmerProductBidController {
	private WebAdaptor<FarmerProductBidWeb, FarmerProductBidModel> webAdaptor = FarmerProductBidWebAdaptor.INSTANCE;
	private ResponseEntityAdaptor<FarmerProductBidWeb, FarmerProductBidModel> responseEntityAdaptor = new ResponseEntityAdaptor<>(webAdaptor);

    @Autowired
    private FarmerProductBidService productBidService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FarmerProductBidWeb> save(@RequestBody FarmerProductBidWeb request) {
    	FarmerProductBidModel requestModel = webAdaptor.toServiceModel(request);
    	FarmerProductBidModel responseModel = productBidService.saveFarmerProductBid(requestModel);

    	return responseEntityAdaptor.createResponseEntity(responseModel);
    }

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<FarmerProductBidWeb> update(@RequestBody FarmerProductBidWeb request) {
		FarmerProductBidModel requestModel = webAdaptor.toServiceModel(request);
		FarmerProductBidModel responseModel = productBidService.updateFarmerProductBid(requestModel);

		return responseEntityAdaptor.createResponseEntity(responseModel);
	}

	@RequestMapping(value="all", method = RequestMethod.GET)
    public ResponseEntity<List<FarmerProductBidWeb>> getAllProductBids() {
        List<FarmerProductBidModel> models = productBidService.getAllFarmerProductBids();

		return responseEntityAdaptor.createResponseEntity(models);
    }

	@RequestMapping(value = "/farmerProductBidId/{farmerProductBidId}", method = RequestMethod.GET)
    public ResponseEntity<FarmerProductBidWeb> getFarmerProductBid(@PathVariable("farmerProductBidId") Long farmerProductBidId) {
		FarmerProductBidModel  responseModel = productBidService.getFarmerProductBid(farmerProductBidId);

    	return responseEntityAdaptor.createResponseEntity(responseModel);
    }

	@RequestMapping(value = "/farmerProductBidId/{farmerProductBidId}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteFarmerProductBid(@PathVariable("farmerProductBidId") Long farmerProductBidId) {
		Boolean response = productBidService.deleteFarmerProductBid(farmerProductBidId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	@RequestMapping(value = "/farmerProductBidId/{farmerProductBidId}", method = RequestMethod.PUT)
    public ResponseEntity<FarmerProductBidWeb> acceptBid(@PathVariable("farmerProductBidId") Long farmerProductBidId) {
		FarmerProductBidModel responseModel = productBidService.acceptBid(farmerProductBidId);

        return responseEntityAdaptor.createResponseEntity(responseModel);
    }

	@RequestMapping(value = "/productId/{productId}/buyerUserId/{buyerUserId}", method = RequestMethod.GET)
    public ResponseEntity<List<FarmerProductBidWeb>> getFarmerProductBidsByProductIdAndBuyerUserId(@PathVariable("productId") Long productId, @PathVariable("productId") Long buyerUserId) {
		List<FarmerProductBidModel>  responseModel = productBidService.getFarmerProductBidsByProductIdAndBuyerUserId(productId, buyerUserId);

    	return responseEntityAdaptor.createResponseEntity(responseModel);
    }

	@RequestMapping(value = "/farmerProductId/{farmerProductId}", method = RequestMethod.GET)
    public ResponseEntity<List<FarmerProductBidWeb>> getFarmerProductBidsByFarmerProductId(@PathVariable("farmerProductId") Long farmerProductId) {
		List<FarmerProductBidModel>  responseModel = productBidService.getFarmerProductBidsByFarmerProductId(farmerProductId);

    	return responseEntityAdaptor.createResponseEntity(responseModel);
    }
}
