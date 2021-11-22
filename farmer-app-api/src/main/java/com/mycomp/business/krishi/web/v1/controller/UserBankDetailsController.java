/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.web.v1.controller;

import com.mycomp.business.krishi.api.adapter.ResponseEntityAdaptor;
import com.mycomp.business.krishi.api.adapter.WebAdaptor;
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
	private WebAdaptor<UserBankDetailsWeb, UserBankDetailsModel> webAdaptor = UserBankDetailsWebAdaptor.INSTANCE;
	private ResponseEntityAdaptor<UserBankDetailsWeb, UserBankDetailsModel> responseEntityAdaptor = new ResponseEntityAdaptor<>(webAdaptor);

    @Autowired
    private UserBankDetailsService userBankDetailsService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserBankDetailsWeb> saveBankDetails(@RequestBody UserBankDetailsWeb bankDetailsRequest) {
		UserBankDetailsModel responseObj = userBankDetailsService
				.saveBankDetails(webAdaptor.toServiceModel(bankDetailsRequest));

		return responseEntityAdaptor.createResponseEntity(responseObj);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<UserBankDetailsWeb> updateBankDetails(@RequestBody UserBankDetailsWeb bankDetailsRequest) {
		UserBankDetailsModel responseObj = userBankDetailsService
				.updateBankDetails(webAdaptor.toServiceModel(bankDetailsRequest));

		return responseEntityAdaptor.createResponseEntity(responseObj);
	}

	@RequestMapping(value = "/{userBankDetailsId}", method = RequestMethod.GET)
	public ResponseEntity<UserBankDetailsWeb> getBankDetails(@PathVariable(value = "userBankDetailsId") Long userBankDetailsId) {
		UserBankDetailsModel addressModel = userBankDetailsService.getBankDetails(userBankDetailsId);

		return responseEntityAdaptor.createResponseEntity(addressModel);
	}

	@RequestMapping(value = "/byUserId/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<UserBankDetailsWeb>> getBankDetailsByUserId(@PathVariable(value = "userId") Long userId) {
		List<UserBankDetailsModel> bankDetailsModels = userBankDetailsService.getBankDetailsByUserId(userId);

		return responseEntityAdaptor.createResponseEntity(bankDetailsModels);
	}


	@RequestMapping(value = "/{userAddressDetailsId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteBankDetails(
			@PathVariable(value = "userBankDetailsId") Long userBankDetailsId) {
		Boolean success = userBankDetailsService.deleteBankDetails(userBankDetailsId);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}

}
