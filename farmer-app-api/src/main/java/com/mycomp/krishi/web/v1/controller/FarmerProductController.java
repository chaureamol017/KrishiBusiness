package com.mycomp.krishi.web.v1.controller;

import com.mycomp.krishi.common.adapter.ResponseEntityAdapter;
import com.mycomp.krishi.common.adapter.WebAdapter;
import com.mycomp.krishi.service.api.FarmerProductService;
import com.mycomp.krishi.service.model.FarmerProductModel;
import com.mycomp.krishi.web.v1.adapter.FarmerProductWebAdapter;
import com.mycomp.krishi.web.v1.model.FarmerProductRequest;
import com.mycomp.krishi.web.v1.model.FarmerProductResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/farmer-product")
public class FarmerProductController {

	private final WebAdapter<FarmerProductRequest, FarmerProductResponse, FarmerProductModel> webAdapter = FarmerProductWebAdapter.INSTANCE;
	private final ResponseEntityAdapter<FarmerProductRequest, FarmerProductResponse, FarmerProductModel> responseEntityAdapter = new ResponseEntityAdapter<>(webAdapter);

	private final FarmerProductService service;

	@Autowired
	public FarmerProductController(final FarmerProductService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<FarmerProductResponse> save(@RequestBody final FarmerProductRequest requestWeb) {
		final FarmerProductModel model = webAdapter.toModel(requestWeb);
		final FarmerProductModel responseModel = service.save(model);

		return responseEntityAdapter.createResponseEntity(responseModel, false);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<FarmerProductResponse> update(@RequestBody final FarmerProductRequest requestWeb) {
		final FarmerProductModel model = webAdapter.toModel(requestWeb);
		final FarmerProductModel responseModel = service.update(model);

		return responseEntityAdapter.createResponseEntity(responseModel, false);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FarmerProductResponse> getById(@PathVariable(value = "id") final Long id) {
		final FarmerProductModel model = service.getById(id);

		return responseEntityAdapter.createResponseEntity(model, false);
	}

	@GetMapping(value = "sell")
	public ResponseEntity<List<FarmerProductResponse>> getProductToSell(@RequestParam("userId") Long userId) {
		final List<FarmerProductModel> models = service.getBySeller(userId);

		return responseEntityAdapter.createResponseEntity(models, false);
	}

	@GetMapping(value = "buy")
	public ResponseEntity<List<FarmerProductResponse>> getProductToBuy(@RequestParam("userId") Long userId) {
		final List<FarmerProductModel> models = service.getForSeller(userId);

		return responseEntityAdapter.createResponseEntity(models, false);
	}

	@GetMapping(value = "search")
	public ResponseEntity<List<FarmerProductResponse>> searchProducts(
			@RequestParam("userId") Long userId,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "search", required = false) String search) {
		final List<FarmerProductModel> models = service.searchProducts(userId, category, city, search);

		return responseEntityAdapter.createResponseEntity(models, false);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteById(@PathVariable(value = "id") Long id) {
		Boolean success = service.deleteById(id);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}
}

