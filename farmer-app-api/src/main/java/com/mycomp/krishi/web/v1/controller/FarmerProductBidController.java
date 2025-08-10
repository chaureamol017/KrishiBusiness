package com.mycomp.krishi.web.v1.controller;

import com.google.common.collect.Lists;
import com.mycomp.common.helper.ResponseEntityHelper;
import com.mycomp.common.response.ApiResponse;
import com.mycomp.krishi.common.adapter.ResponseEntityAdapter;
import com.mycomp.krishi.common.adapter.WebAdapter;
import com.mycomp.krishi.service.api.FarmerProductBidService;
import com.mycomp.krishi.service.model.FarmerProductBidModel;
import com.mycomp.krishi.user.adapter.UserWebAdapter;
import com.mycomp.krishi.user.model.UserModel;
import com.mycomp.krishi.user.requests.UserWeb;
import com.mycomp.krishi.user.service.UserService;
import com.mycomp.krishi.web.v1.adapter.FarmerProductBidWebAdapter;
import com.mycomp.krishi.web.v1.model.FarmerProductBidRequest;
import com.mycomp.krishi.web.v1.model.FarmerProductBidResponse;

import com.mycomp.krishi.web.v1.model.FarmerProductViewBid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/farmer-product-bid")
public class FarmerProductBidController {
	private WebAdapter<FarmerProductBidRequest, FarmerProductBidResponse, FarmerProductBidModel> webAdapter = FarmerProductBidWebAdapter.INSTANCE;
	private com.mycomp.common.adapter.WebAdapter<UserWeb, UserModel> userWebAdapter = UserWebAdapter.INSTANCE;

	private ResponseEntityAdapter<FarmerProductBidRequest, FarmerProductBidResponse, FarmerProductBidModel> responseEntityAdapter = new ResponseEntityAdapter<>(webAdapter);

	private FarmerProductBidService service;
	private UserService userService;

	@Autowired
	public FarmerProductBidController(FarmerProductBidService service, UserService userService) {
		this.service = service;
		this.userService = userService;
	}

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

	@RequestMapping(value = "/{productBidId}", method = RequestMethod.PUT)
	public ResponseEntity<ApiResponse<Integer>> acceptBid( @PathVariable("productBidId") final Long productBidId) {
		final int updateCount = service.acceptBid(productBidId);

		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "", updateCount));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FarmerProductBidResponse> getById(@PathVariable(value = "id") final Long id) {
		final FarmerProductBidModel model = service.getById(id);

		return responseEntityAdapter.createResponseEntity(model, false);
	}

	@RequestMapping(value = "/user/{userId}/product/{productId}", method = RequestMethod.GET)
	public ResponseEntity<FarmerProductBidResponse> getBidForBuyerAndProduct(@PathVariable("userId") final Long userId, @PathVariable("productId") final Long productId) {
		final FarmerProductBidModel model = service.getBidForBuyerAndProduct(userId, productId);

		return responseEntityAdapter.createResponseEntity(model, true);
	}

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	public ResponseEntity<FarmerProductViewBid> getBidForProduct( @PathVariable("productId") final Long productId) {
		final List<FarmerProductBidModel> models = service.getBidForProduct(productId);
		final List<FarmerProductBidResponse> bids = webAdapter.toWeb(models);
		final List<Long> userIds = Lists.transform(models, FarmerProductBidModel::getBuyerUserId);
		final List<UserModel> userModels = userService.getUsers(userIds);

		final List<UserWeb> buyers = userWebAdapter.toWeb(userModels);

		return ResponseEntityHelper.toSuccessResponseEntity(new FarmerProductViewBid(bids, buyers));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteById(@PathVariable(value = "id") Long id) {
		Boolean success = service.deleteById(id);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}
}

