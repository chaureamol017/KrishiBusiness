package com.mycomp.krishi.web.v1.controller;

import com.mycomp.krishi.common.adapter.ResponseEntityAdapter;
import com.mycomp.krishi.common.adapter.WebAdapter;
import com.mycomp.krishi.service.api.ProductService;
import com.mycomp.krishi.service.model.ProductModel;
import com.mycomp.krishi.web.v1.adapter.ProductWebAdapter;
import com.mycomp.krishi.web.v1.model.ProductRequest;
import com.mycomp.krishi.web.v1.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/products")
public class ProductController {
	private final WebAdapter<ProductRequest, ProductResponse, ProductModel> webAdapter = ProductWebAdapter.INSTANCE;
	private final ResponseEntityAdapter<ProductRequest, ProductResponse, ProductModel> responseEntityAdapter = new ResponseEntityAdapter<>(webAdapter);

	private final ProductService service;

	@Autowired
	public ProductController(final ProductService service) {
		this.service = service;
	}

	@PostMapping()
	public ResponseEntity<ProductResponse> save(@RequestBody final ProductRequest requestWeb) {
		final ProductModel model = webAdapter.toModel(requestWeb);
		final ProductModel responseModel = service.save(model);

		return responseEntityAdapter.createResponseEntity(responseModel, false);
	}

	@PutMapping()
	public ResponseEntity<ProductResponse> update(@RequestBody final ProductRequest requestWeb) {
		final ProductModel model = webAdapter.toModel(requestWeb);
		final ProductModel responseModel = service.update(model);

		return responseEntityAdapter.createResponseEntity(responseModel, false);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductResponse> getById(@PathVariable(value = "id") final Long id) {
		final ProductModel model = service.getById(id);

		return responseEntityAdapter.createResponseEntity(model, false);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<ProductResponse>> getAll() {
		final List<ProductModel> models = service.getAll();

		return responseEntityAdapter.createResponseEntity(models, false);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable(value = "id") Long id) {
		Boolean success = service.deleteById(id);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}
}

