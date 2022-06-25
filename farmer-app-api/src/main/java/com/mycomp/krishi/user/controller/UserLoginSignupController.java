/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.user.controller;

import com.mycomp.common.adapter.ResponseEntityAdapter;
import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.user.adapter.ChangePasswordRequestParamsAdapter;
import com.mycomp.krishi.user.adapter.ResetPasswordRequestParamsAdapter;
import com.mycomp.krishi.user.adapter.SignupRequestParamsAdapter;
import com.mycomp.krishi.user.adapter.UserWebAdapter;
import com.mycomp.krishi.user.model.ChangePasswordRequestModel;
import com.mycomp.krishi.user.model.ResetPasswordRequestModel;
import com.mycomp.krishi.user.model.SignupRequestModel;
import com.mycomp.krishi.user.model.UserModel;
import com.mycomp.krishi.user.requests.ChangePasswordRequestParams;
import com.mycomp.krishi.user.requests.ResetPasswordRequestParams;
import com.mycomp.krishi.user.requests.SignupRequestParams;
import com.mycomp.krishi.user.requests.UserWeb;
import com.mycomp.krishi.user.service.UserLoginSignupService;

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
	private WebAdapter<ResetPasswordRequestParams, ResetPasswordRequestModel> resetPasswordWebAdapter = ResetPasswordRequestParamsAdapter.INSTANCE;
	private WebAdapter<ChangePasswordRequestParams, ChangePasswordRequestModel> changePasswordWebAdapter = ChangePasswordRequestParamsAdapter.INSTANCE;
	private WebAdapter<SignupRequestParams, SignupRequestModel> webAdapter = SignupRequestParamsAdapter.INSTANCE;
	private ResponseEntityAdapter<UserWeb, UserModel> responseEntityAdapter = new ResponseEntityAdapter<>(UserWebAdapter.INSTANCE);

	@Autowired
	private UserLoginSignupService userLoginSignupService;

	@PostMapping("/signup")
	public ResponseEntity<Boolean> signupUser(@RequestBody SignupRequestParams requestParams) {
		SignupRequestModel model = webAdapter.toModel(requestParams);
		Boolean success = userLoginSignupService.signupUser(model);

		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	@GetMapping("/validate")
	public ResponseEntity<UserWeb> validateUserByEmailAndPassword(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) {
		final UserModel userModel = userLoginSignupService.validateUserByUserNameAndPassword(userName, password);

		return responseEntityAdapter.createResponseEntity(userModel);
	}

	@PostMapping("/password/change")
	public ResponseEntity<Map<String, Object>> changePassword(@RequestBody ChangePasswordRequestParams requestParams) {
		final ChangePasswordRequestModel model = changePasswordWebAdapter.toModel(requestParams);
		Map<String, Object> response = userLoginSignupService.changePassword(model);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/password/reset")
	public ResponseEntity<Map<String, Object>> resetPassword(@RequestBody ResetPasswordRequestParams requestParams) {
		final ResetPasswordRequestModel model = resetPasswordWebAdapter.toModel(requestParams);
		Map<String, Object> response = userLoginSignupService.resetPassword(model);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
