/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.web.v1.controller;

import com.mycomp.common.adapter.ResponseEntityAdapter;
import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.service.api.ProductService;
import com.mycomp.krishi.service.model.ProductModel;
import com.mycomp.krishi.web.v1.adapter.ProductWebAdapter;
import com.mycomp.krishi.web.v1.model.ProductWeb;

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
	private WebAdapter<ProductWeb, ProductModel> webAdapter = ProductWebAdapter.INSTANCE;
	private ResponseEntityAdapter<ProductWeb, ProductModel> responseEntityAdapter = new ResponseEntityAdapter<>(webAdapter);

	@Autowired private ProductService productService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProductWeb> saveProduct(@RequestBody ProductWeb requestWeb) {
		ProductModel model = webAdapter.toModel(requestWeb);
		ProductModel responseModel = productService.saveProduct(model);

		return responseEntityAdapter.createResponseEntity(responseModel);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ProductWeb> updateProduct(@RequestBody ProductWeb requestWeb) {
		ProductModel model = webAdapter.toModel(requestWeb);
		ProductModel responseModel = productService.updateProduct(model);

		return responseEntityAdapter.createResponseEntity(responseModel);
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ResponseEntity<ProductWeb> getProduct(@PathVariable(value = "productId") Long productId) {
		ProductModel model = productService.getProduct(productId);

		return responseEntityAdapter.createResponseEntity(model);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<ProductWeb>> getAllProducts() {
		List<ProductModel> models = productService.getAllProducts();

		return responseEntityAdapter.createResponseEntity(models);
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteProduct(@PathVariable(value = "productId") Long productId) {
		Boolean success = productService.deleteProduct(productId);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}
}
