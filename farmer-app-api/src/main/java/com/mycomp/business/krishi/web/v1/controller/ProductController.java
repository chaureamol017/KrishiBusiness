/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.web.v1.controller;

import com.google.common.collect.Lists;
import com.mycomp.business.krishi.service.api.ProductService;
import com.mycomp.business.krishi.service.api.model.ProductModel;
import com.mycomp.business.krishi.web.v1.model.ProductWeb;
import com.mycomp.business.krishi.web.v1.adaptor.ProductWebAdaptor;

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
@RequestMapping("v1/product")
public class ProductController {
	@Autowired private ProductService productService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProductWeb> saveProduct(@RequestBody ProductWeb requestWeb) {
		ProductModel responseModel = productService
				.saveProduct(ProductWebAdaptor.toServiceModel(requestWeb));

		ProductWeb web = ProductWebAdaptor.toWebModel(responseModel);

		return new ResponseEntity<>(web, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ProductWeb> updateProduct(
			@RequestBody ProductWeb requestWeb) {
		ProductModel responseModel = productService
				.updateProduct(ProductWebAdaptor.toServiceModel(requestWeb));

		ProductWeb web = ProductWebAdaptor.toWebModel(responseModel);

		return new ResponseEntity<>(web, HttpStatus.OK);
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ResponseEntity<ProductWeb> getProduct(
			@PathVariable(value = "productId") Long productId) {
		ProductModel model = productService.getProduct(productId);
		ProductWeb web = ProductWebAdaptor.toWebModel(model);

		return new ResponseEntity<>(web, HttpStatus.OK);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<ProductWeb>> getAllProducts() {
		List<ProductModel> models = productService.getAllProducts();
		
		List<ProductWeb> web = Lists.transform(models, ProductWebAdaptor::toWebModel);
		return new ResponseEntity<>(web, HttpStatus.OK);
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteProduct(
			@PathVariable(value = "productId") Long productId) {
		Boolean success = productService.deleteProduct(productId);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}
}
