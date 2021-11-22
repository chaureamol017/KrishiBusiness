/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.web.v1.controller;

import com.mycomp.business.krishi.api.adapter.ResponseEntityAdaptor;
import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.UserAddressDetailsService;
import com.mycomp.business.krishi.service.api.model.UserAddressDetailsModel;
import com.mycomp.business.krishi.web.v1.model.UserAddressDetailsWeb;
import com.mycomp.business.krishi.web.v1.adaptor.UserAddressDetailsWebAdaptor;

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
@RequestMapping("v1/address")
public class UserAddressController {
	private WebAdaptor<UserAddressDetailsWeb, UserAddressDetailsModel> webAdaptor = new UserAddressDetailsWebAdaptor();
	private ResponseEntityAdaptor<UserAddressDetailsWeb, UserAddressDetailsModel> responseEntityAdaptor = new ResponseEntityAdaptor<>(webAdaptor);

	@Autowired private UserAddressDetailsService userAddressDetailsService;

	@RequestMapping(value = "/addressDetails", method = RequestMethod.POST)
	public ResponseEntity<UserAddressDetailsWeb> saveAddressDetails(@RequestBody UserAddressDetailsWeb addressRequest) {
		UserAddressDetailsModel responseObj = userAddressDetailsService
				.saveAddressDetails(webAdaptor.toServiceModel(addressRequest));

		return responseEntityAdaptor.createResponseEntity(responseObj);
	}

	@RequestMapping(value = "/addressDetails", method = RequestMethod.PUT)
	public ResponseEntity<UserAddressDetailsWeb> updateAddressDetails(
			@RequestBody UserAddressDetailsWeb addressRequest) {
		UserAddressDetailsModel responseObj = userAddressDetailsService
				.updateAddressDetails(webAdaptor.toServiceModel(addressRequest));

		return responseEntityAdaptor.createResponseEntity(responseObj);
	}

	@RequestMapping(value = "/addressDetails/{userAddressDetailsId}", method = RequestMethod.GET)
	public ResponseEntity<UserAddressDetailsWeb> getAddressDetails(
			@PathVariable(value = "userAddressDetailsId") Long userAddressDetailsId) {
		UserAddressDetailsModel addressModel = userAddressDetailsService.getAddressDetails(userAddressDetailsId);

		return responseEntityAdaptor.createResponseEntity(addressModel);
	}

	@RequestMapping(value = "/addressDetails/byUserId/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<UserAddressDetailsWeb>> getAddressDetailsByUserId(
			@PathVariable(value = "userId") Long userId) {
		List<UserAddressDetailsModel> addressModels = userAddressDetailsService.getAddressDetailsByUserId(userId);

		return responseEntityAdaptor.createResponseEntity(addressModels);
	}


	@RequestMapping(value = "/addressDetails/{userAddressDetailsId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAddressDetails(
			@PathVariable(value = "userAddressDetailsId") Long userAddressDetailsId) {
		Boolean success = userAddressDetailsService.deleteAddressDetails(userAddressDetailsId);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}

}
