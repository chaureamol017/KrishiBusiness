/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.web.v1.controller;

import com.mycomp.business.krishi.api.adapter.ResponseEntityAdaptor;
import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.ProductPriceHistoryService;
import com.mycomp.business.krishi.service.api.ProductPriceService;
import com.mycomp.business.krishi.service.api.model.ProductPriceHistoryModel;
import com.mycomp.business.krishi.service.api.model.ProductPriceModel;
import com.mycomp.business.krishi.web.v1.model.ProductPriceHistoryWeb;
import com.mycomp.business.krishi.web.v1.model.ProductPriceWeb;
import com.mycomp.business.krishi.web.v1.adaptor.ProductPriceHistoryWebAdaptor;
import com.mycomp.business.krishi.web.v1.adaptor.ProductPriceWebAdaptor;

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
@RequestMapping("v1/productprice")
public class ProductPriceController {
	private WebAdaptor<ProductPriceHistoryWeb, ProductPriceHistoryModel> priceHistoryWebAdaptor = ProductPriceHistoryWebAdaptor.INSTANCE;
	private WebAdaptor<ProductPriceWeb, ProductPriceModel> webAdaptor = ProductPriceWebAdaptor.INSTANCE;
	private ResponseEntityAdaptor<ProductPriceHistoryWeb, ProductPriceHistoryModel> priceHistoryResponseEntityAdaptor = new ResponseEntityAdaptor<>(priceHistoryWebAdaptor);
	private ResponseEntityAdaptor<ProductPriceWeb, ProductPriceModel> responseEntityAdaptor = new ResponseEntityAdaptor<>(webAdaptor);


	@Autowired private ProductPriceService productPriceService;
	@Autowired private ProductPriceHistoryService productPriceHistoryService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProductPriceWeb> saveProductPrice(@RequestBody ProductPriceWeb requestWeb) {
		ProductPriceModel model = webAdaptor.toServiceModel(requestWeb);
		ProductPriceModel responseModel = productPriceService.saveProductPrice(model);

		return responseEntityAdaptor.createResponseEntity(responseModel);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ProductPriceWeb> updateProductPrice(@RequestBody ProductPriceWeb requestWeb) {
		ProductPriceModel model = webAdaptor.toServiceModel(requestWeb);
		ProductPriceModel responseModel = productPriceService.updateProductPrice(model);

		return responseEntityAdaptor.createResponseEntity(responseModel);
	}

	@RequestMapping(value = "/{productPriceId}", method = RequestMethod.GET)
	public ResponseEntity<ProductPriceWeb> getProductPrice(@PathVariable(value = "productPriceId") Long productPriceId) {
		ProductPriceModel model = productPriceService.getProductPrice(productPriceId);

		return responseEntityAdaptor.createResponseEntity(model);
	}

	@RequestMapping(value = "/{productPriceId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteProductPrice(@PathVariable(value = "productPriceId") Long productPriceId) {
		Boolean success = productPriceService.deleteProductPrice(productPriceId);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	@RequestMapping(value = "/history/product/{productId}", method = RequestMethod.GET)
	public ResponseEntity<List<ProductPriceHistoryWeb>> getProductPriceHistoryByProductId(@PathVariable(value = "productId") Long productId) {
		List<ProductPriceHistoryModel> models = productPriceHistoryService.getProductPriceHistoryByProductId(productId);

		return priceHistoryResponseEntityAdaptor.createResponseEntity(models);
	}

	@RequestMapping(value = "/history/{productPriceHistoryId}", method = RequestMethod.GET)
	public ResponseEntity<ProductPriceHistoryWeb> getProductPriceHistory(@PathVariable(value = "productPriceHistoryId") Long productPriceHistoryId) {
		ProductPriceHistoryModel model = productPriceHistoryService.getProductPriceHistory(productPriceHistoryId);

		return priceHistoryResponseEntityAdaptor.createResponseEntity(model);
	}
}
