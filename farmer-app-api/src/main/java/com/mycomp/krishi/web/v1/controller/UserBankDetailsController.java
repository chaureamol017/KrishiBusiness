/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.web.v1.controller;

import com.mycomp.common.adapter.ResponseEntityAdapter;
import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.service.api.UserBankDetailsService;
import com.mycomp.krishi.service.model.UserBankDetailsModel;
import com.mycomp.krishi.web.v1.adapter.UserBankDetailsWebAdapter;
import com.mycomp.krishi.web.v1.model.UserBankDetailsWeb;

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
	private WebAdapter<UserBankDetailsWeb, UserBankDetailsModel> webAdapter = UserBankDetailsWebAdapter.INSTANCE;
	private ResponseEntityAdapter<UserBankDetailsWeb, UserBankDetailsModel> responseEntityAdapter = new ResponseEntityAdapter<>(webAdapter);

    @Autowired
    private UserBankDetailsService userBankDetailsService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserBankDetailsWeb> saveBankDetails(@RequestBody UserBankDetailsWeb bankDetailsRequest) {
		UserBankDetailsModel responseObj = userBankDetailsService
				.saveBankDetails(webAdapter.toModel(bankDetailsRequest));

		return responseEntityAdapter.createResponseEntity(responseObj);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<UserBankDetailsWeb> updateBankDetails(@RequestBody UserBankDetailsWeb bankDetailsRequest) {
		UserBankDetailsModel responseObj = userBankDetailsService
				.updateBankDetails(webAdapter.toModel(bankDetailsRequest));

		return responseEntityAdapter.createResponseEntity(responseObj);
	}

	@RequestMapping(value = "/{userBankDetailsId}", method = RequestMethod.GET)
	public ResponseEntity<UserBankDetailsWeb> getBankDetails(@PathVariable(value = "userBankDetailsId") Long userBankDetailsId) {
		UserBankDetailsModel addressModel = userBankDetailsService.getBankDetails(userBankDetailsId);

		return responseEntityAdapter.createResponseEntity(addressModel);
	}

	@RequestMapping(value = "/byUserId/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<UserBankDetailsWeb>> getBankDetailsByUserId(@PathVariable(value = "userId") Long userId) {
		List<UserBankDetailsModel> bankDetailsModels = userBankDetailsService.getBankDetailsByUserId(userId);

		return responseEntityAdapter.createResponseEntity(bankDetailsModels);
	}


	@RequestMapping(value = "/{userAddressDetailsId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteBankDetails(
			@PathVariable(value = "userBankDetailsId") Long userBankDetailsId) {
		Boolean success = userBankDetailsService.deleteBankDetails(userBankDetailsId);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}

}
