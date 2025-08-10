package com.mycomp.krishi.web.v1.controller;

import com.mycomp.common.helper.ResponseEntityHelper;
import com.mycomp.common.response.ApiResponse;
import com.mycomp.krishi.common.adapter.ResponseEntityAdapter;
import com.mycomp.krishi.common.adapter.WebAdapter;
import com.mycomp.krishi.service.api.FarmerProductBidService;
import com.mycomp.krishi.service.model.FarmerProductBidModel;
import com.mycomp.krishi.user.requests.AuthApiResponse;
import com.mycomp.krishi.web.v1.adapter.FarmerProductBidWebAdapter;
import com.mycomp.krishi.web.v1.model.FarmerProductBidRequest;
import com.mycomp.krishi.web.v1.model.FarmerProductBidResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/farmer-product-bid")
public class FarmerProductBidController {
	private WebAdapter<FarmerProductBidRequest, FarmerProductBidResponse, FarmerProductBidModel> webAdapter = FarmerProductBidWebAdapter.INSTANCE;
	private ResponseEntityAdapter<FarmerProductBidRequest, FarmerProductBidResponse, FarmerProductBidModel> responseEntityAdapter = new ResponseEntityAdapter<>(webAdapter);

	@Autowired private FarmerProductBidService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ApiResponse<FarmerProductBidResponse>> save(@RequestBody final FarmerProductBidRequest requestWeb) {
		try {
			final FarmerProductBidModel model = webAdapter.toModel(requestWeb);
			final FarmerProductBidModel responseModel = service.save(model);

			final FarmerProductBidResponse response = webAdapter.toWeb(responseModel);
			return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "success", response));
		} catch (RuntimeException ex) {
			return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(false, ex.getMessage(), null));
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ApiResponse<FarmerProductBidResponse>> update(@RequestBody final FarmerProductBidRequest requestWeb) {
		try {
			final FarmerProductBidModel model = webAdapter.toModel(requestWeb);
			final FarmerProductBidModel responseModel = service.update(model);

			final FarmerProductBidResponse response = webAdapter.toWeb(responseModel);
			return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "success", response));
		} catch (RuntimeException ex) {
			return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(false, ex.getMessage(), null));
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FarmerProductBidResponse> getById(@PathVariable(value = "id") final Long id) {
		final FarmerProductBidModel model = service.getById(id);

		return responseEntityAdapter.createResponseEntity(model, false);
	}

	@RequestMapping(value = "/user/{userId}/product/{productId}", method = RequestMethod.GET)
	public ResponseEntity<FarmerProductBidResponse> getBid(@PathVariable("userId") final Long userId, @PathVariable("productId") final Long productId) {
		final FarmerProductBidModel model = service.getBid(userId, productId);

		return responseEntityAdapter.createResponseEntity(model, true);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteById(@PathVariable(value = "id") Long id) {
		Boolean success = service.deleteById(id);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}
}

