/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.web.v1.controller;

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
	@Autowired
	private UserAddressDetailsService userAddressDetailsService;

	@RequestMapping(value = "/addressDetails", method = RequestMethod.POST)
	public ResponseEntity<UserAddressDetailsWeb> saveAddressDetails(@RequestBody UserAddressDetailsWeb addressRequest) {
		UserAddressDetailsModel responseObj = userAddressDetailsService
				.saveAddressDetails(UserAddressDetailsWebAdaptor.toServiceModel(addressRequest));

		UserAddressDetailsWeb addressWeb = UserAddressDetailsWebAdaptor.toWebModel(responseObj);

		return new ResponseEntity<>(addressWeb, HttpStatus.OK);
	}

	@RequestMapping(value = "/addressDetails", method = RequestMethod.PUT)
	public ResponseEntity<UserAddressDetailsWeb> updateAddressDetails(
			@RequestBody UserAddressDetailsWeb addressRequest) {
		UserAddressDetailsModel responseObj = userAddressDetailsService
				.updateAddressDetails(UserAddressDetailsWebAdaptor.toServiceModel(addressRequest));

		UserAddressDetailsWeb addressWeb = UserAddressDetailsWebAdaptor.toWebModel(responseObj);

		return new ResponseEntity<>(addressWeb, HttpStatus.OK);
	}

	@RequestMapping(value = "/addressDetails/{userAddressDetailsId}", method = RequestMethod.GET)
	public ResponseEntity<UserAddressDetailsWeb> getAddressDetails(
			@PathVariable(value = "userAddressDetailsId") Long userAddressDetailsId) {
		UserAddressDetailsModel addressModel = userAddressDetailsService.getAddressDetails(userAddressDetailsId);
		UserAddressDetailsWeb addressWeb = UserAddressDetailsWebAdaptor.toWebModel(addressModel);

		return new ResponseEntity<>(addressWeb, HttpStatus.OK);
	}

	@RequestMapping(value = "/addressDetails/byUserId/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<UserAddressDetailsWeb>> getAddressDetailsByUserId(
			@PathVariable(value = "userId") Long userId) {
		List<UserAddressDetailsModel> addressModels = userAddressDetailsService.getAddressDetailsByUserId(userId);

		List<UserAddressDetailsWeb> addressWebModels = UserAddressDetailsWebAdaptor.toWebModel(addressModels);

		return new ResponseEntity<>(addressWebModels, HttpStatus.OK);
	}


	@RequestMapping(value = "/addressDetails/{userAddressDetailsId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAddressDetails(
			@PathVariable(value = "userAddressDetailsId") Long userAddressDetailsId) {
		Boolean success = userAddressDetailsService.deleteAddressDetails(userAddressDetailsId);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}

}
