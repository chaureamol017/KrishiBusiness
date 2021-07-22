/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.web.v1.controller;

import com.mycomp.business.krishi.service.api.model.ChangePasswordRequestModel;
import com.mycomp.business.krishi.service.api.model.ResetPasswordRequestModel;
import com.mycomp.business.krishi.service.api.model.SignupRequestModel;
import com.mycomp.business.krishi.service.api.model.UserModel;
import com.mycomp.business.krishi.service.api.UserLoginSignupService;
import com.mycomp.business.krishi.web.v1.model.UserWeb;
import com.mycomp.business.krishi.web.v1.adaptor.ChangePasswordRequestParamsAdaptor;
import com.mycomp.business.krishi.web.v1.adaptor.ResetPasswordRequestParamsAdaptor;
import com.mycomp.business.krishi.web.v1.adaptor.SignupRequestParamsAdaptor;
import com.mycomp.business.krishi.web.v1.adaptor.UserWebAdaptor;
import com.mycomp.business.krishi.web.v1.model.ChangePasswordRequestParams;
import com.mycomp.business.krishi.web.v1.model.ResetPasswordRequestParams;
import com.mycomp.business.krishi.web.v1.model.SignupRequestParams;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Amol
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/user")
public class UserLoginSignupController {

	@Autowired
	private UserLoginSignupService userLoginSignupService;

	@PostMapping("/signup")
	public ResponseEntity<Boolean> signupUser(@RequestBody SignupRequestParams requestParams) {
		SignupRequestModel model = SignupRequestParamsAdaptor.toServiceModel(requestParams);
		Boolean success = userLoginSignupService.signupUser(model);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	@GetMapping("/validate")
	public ResponseEntity<UserWeb> validateUserByEmailAndPassword(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) {
		final UserModel userModel = userLoginSignupService.validateUserByUserNameAndPassword(userName, password);

		final UserWeb web = UserWebAdaptor.toWebModel(userModel);

		return new ResponseEntity<>(web, HttpStatus.OK);
	}

	@PostMapping("/password/change")
	public ResponseEntity<Map<String, Object>> changePassword(@RequestBody ChangePasswordRequestParams requestParams) {
		final ChangePasswordRequestModel model = ChangePasswordRequestParamsAdaptor.toServiceModel(requestParams);
		Map<String, Object> response = userLoginSignupService.changePassword(model);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/password/reset")
	public ResponseEntity<Map<String, Object>> resetPassword(@RequestBody ResetPasswordRequestParams requestParams) {
		final ResetPasswordRequestModel model = ResetPasswordRequestParamsAdaptor.toServiceModel(requestParams);
		Map<String, Object> response = userLoginSignupService.resetPassword(model);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
