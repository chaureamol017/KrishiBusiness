/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.web.v1.controller;

import com.mycomp.business.krishi.service.api.UserBankDetailsService;
import com.mycomp.business.krishi.service.api.model.UserBankDetailsModel;
import com.mycomp.business.krishi.web.v1.model.UserBankDetailsWeb;
import com.mycomp.business.krishi.web.v1.adaptor.UserBankDetailsWebAdaptor;

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
@RequestMapping("v1/bankdetails")
public class UserBankDetailsController {
    @Autowired
    private UserBankDetailsService userBankDetailsService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserBankDetailsWeb> saveBankDetails(@RequestBody UserBankDetailsWeb bankDetailsRequest) {
		UserBankDetailsModel responseObj = userBankDetailsService
				.saveBankDetails(UserBankDetailsWebAdaptor.toServiceModel(bankDetailsRequest));

		UserBankDetailsWeb addressWeb = UserBankDetailsWebAdaptor.toWebModel(responseObj);

		return new ResponseEntity<>(addressWeb, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<UserBankDetailsWeb> updateBankDetails(
			@RequestBody UserBankDetailsWeb bankDetailsRequest) {
		UserBankDetailsModel responseObj = userBankDetailsService
				.updateBankDetails(UserBankDetailsWebAdaptor.toServiceModel(bankDetailsRequest));

		UserBankDetailsWeb bankDetailsWeb = UserBankDetailsWebAdaptor.toWebModel(responseObj);

		return new ResponseEntity<>(bankDetailsWeb, HttpStatus.OK);
	}

	@RequestMapping(value = "/{userBankDetailsId}", method = RequestMethod.GET)
	public ResponseEntity<UserBankDetailsWeb> getBankDetails(
			@PathVariable(value = "userBankDetailsId") Long userBankDetailsId) {
		UserBankDetailsModel addressModel = userBankDetailsService.getBankDetails(userBankDetailsId);
		UserBankDetailsWeb bankDetailsWeb = UserBankDetailsWebAdaptor.toWebModel(addressModel);

		return new ResponseEntity<>(bankDetailsWeb, HttpStatus.OK);
	}

	@RequestMapping(value = "/byUserId/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<UserBankDetailsWeb>> getBankDetailsByUserId(
			@PathVariable(value = "userId") Long userId) {
		List<UserBankDetailsModel> bankDetailsModels = userBankDetailsService.getBankDetailsByUserId(userId);

		List<UserBankDetailsWeb> bankWebModels = UserBankDetailsWebAdaptor.toWebModel(bankDetailsModels);

		return new ResponseEntity<>(bankWebModels, HttpStatus.OK);
	}


	@RequestMapping(value = "/{userAddressDetailsId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAddressDetails(
			@PathVariable(value = "userBankDetailsId") Long userBankDetailsId) {
		Boolean success = userBankDetailsService.deleteAddressDetails(userBankDetailsId);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}

}
