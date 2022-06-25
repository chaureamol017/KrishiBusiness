/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.web.v1.controller;

import com.mycomp.common.adapter.ResponseEntityAdapter;
import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.service.api.FarmerProductService;
import com.mycomp.krishi.service.model.FarmerProductModel;
import com.mycomp.krishi.web.v1.adapter.FarmerProductWebAdapter;
import com.mycomp.krishi.web.v1.model.FarmerProductWeb;

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
@RequestMapping("v1/farmer-product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FarmerProductController {
	private WebAdapter<FarmerProductWeb, FarmerProductModel> webAdapter = FarmerProductWebAdapter.INSTANCE;
	private ResponseEntityAdapter<FarmerProductWeb, FarmerProductModel> responseEntityAdapter = new ResponseEntityAdapter<>(webAdapter);

	@Autowired
	private FarmerProductService farmerProductService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<FarmerProductWeb> save(@RequestBody FarmerProductWeb request) {
		FarmerProductModel requestModel = webAdapter.toModel(request);
		FarmerProductModel model = farmerProductService.saveFarmerProduct(requestModel);

		return responseEntityAdapter.createResponseEntity(model);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<FarmerProductWeb> update(@RequestBody FarmerProductWeb request) {
		FarmerProductModel requestModel = webAdapter.toModel(request);
		FarmerProductModel model = farmerProductService.updateFarmerProduct(requestModel);

		return responseEntityAdapter.createResponseEntity(model);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<FarmerProductWeb>> getAllFarmerProduct() {
		List<FarmerProductModel> models = farmerProductService.getAllFarmerProducts();

		return responseEntityAdapter.createResponseEntity(models);
	}

	@RequestMapping(value = "/farmerProductId/{farmerProductId}", method = RequestMethod.GET)
	public ResponseEntity<FarmerProductWeb> getFarmerProduct(@PathVariable("farmerProductId") Long farmerProductId) {
		FarmerProductModel model = farmerProductService.getFarmerProduct(farmerProductId);

		return responseEntityAdapter.createResponseEntity(model);
	}

	@RequestMapping(value = "/farmerProductId/{farmerProductId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteFarmerProduct(@PathVariable("farmerProductId") Long farmerProductId) {
		Boolean result = farmerProductService.deleteFarmerProduct(farmerProductId);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/productId/{productId}", method = RequestMethod.GET)
	ResponseEntity<List<FarmerProductWeb>> getFarmerProductsByProductId(@PathVariable("productId") Long productId) {
		List<FarmerProductModel> models = farmerProductService.getFarmerProductsByProductId(productId);

		return responseEntityAdapter.createResponseEntity(models);
	}

	@RequestMapping(value = "/productId/{productId}/userId/{userId}", method = RequestMethod.GET)
	ResponseEntity<List<FarmerProductWeb>> getFarmerProductsByProductIdAndUserId(
			@PathVariable("productId") Long productId, @PathVariable("userId") Long userId) {
		List<FarmerProductModel> models = farmerProductService.getFarmerProductsByProductIdAndUserId(productId, userId);

		return responseEntityAdapter.createResponseEntity(models);
	}

	@RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET)
	ResponseEntity<List<FarmerProductWeb>>  getFarmerProductsByUserId(@PathVariable("userId") Long userId) {
		List<FarmerProductModel> models = farmerProductService.getFarmerProductsByUserId(userId);

		return responseEntityAdapter.createResponseEntity(models);
	}

	@RequestMapping(value = "/userId/{userId}/sold/{sold}", method = RequestMethod.GET)
	ResponseEntity<List<FarmerProductWeb>> getFarmerProductsByUserIdAndSoldStatus(@PathVariable("userId") Long userId, @PathVariable("sold") Boolean sold) {
		List<FarmerProductModel> models = farmerProductService.getFarmerProductsByUserId(userId);

		return responseEntityAdapter.createResponseEntity(models);
	}


	@RequestMapping(value = "/productId/{productId}/userId/{userId}/sold/{sold}", method = RequestMethod.GET)
	ResponseEntity<List<FarmerProductWeb>> getFarmerProductsByProductIdUserIdAndSoldStatus(@PathVariable("productId") Long productId, @PathVariable("userId") Long userId, @PathVariable("sold") Boolean sold)  {
		List<FarmerProductModel> models = farmerProductService.getFarmerProductsByProductIdUserIdAndSoldStatus(productId, userId, sold);

		return responseEntityAdapter.createResponseEntity(models);
	}
}
