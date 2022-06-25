/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.user.service;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.common.operations.CommonUtils;
import com.mycomp.krishi.dataprovider.repository.UserLoginRepository;
import com.mycomp.krishi.persistence.entity.User;
import com.mycomp.krishi.persistence.entity.UserLogin;
import com.mycomp.krishi.user.adapter.SignupRequestToUserLoginAdapter;
import com.mycomp.krishi.user.adapter.UserModelAdapter;
import com.mycomp.krishi.user.model.ChangePasswordRequestModel;
import com.mycomp.krishi.user.model.ResetPasswordRequestModel;
import com.mycomp.krishi.user.model.SignupRequestModel;
import com.mycomp.krishi.user.model.UserModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class UserLoginSignupServiceImpl implements UserLoginSignupService {
	private ModelAdapter<SignupRequestModel, UserLogin> modelAdapter = SignupRequestToUserLoginAdapter.INSTANCE;
	private ModelAdapter<UserModel, User> userModelAdaptor = UserModelAdapter.INSTANCE;

	@Autowired private UserService userService;
	@Autowired private UserLoginRepository userLoginRepository;

	@Override
	public Boolean signupUser(SignupRequestModel signupRequest) {
		UserModel userModel = userService.saveUser(signupRequest);

		signupRequest.setUserId(userModel.getUserId());
		UserLogin userLogin = modelAdapter.toEntityMinimal(signupRequest);
		userLoginRepository.save(userLogin);

		return true;
	}

	@Override
	public UserModel validateUserByUserNameAndPassword(String userName, String password) {

		List<UserLogin> userLoginList = userLoginRepository.validateUser(userName, password);
		if (userLoginList != null && !userLoginList.isEmpty()) {
			User user = userLoginList.get(0).getUser();

			return userModelAdaptor.toModel(user);
		}
		return null;
	}

	@Override
	public Map<String, Object> changePassword(ChangePasswordRequestModel requestModel) {
		final Map<String, Object> response = checkAndUpdatePassword(requestModel.getUserName(),
				requestModel.getOldPassword(), requestModel.getNewPassword(), true);
		return response;
	}

	@Override
	public Map<String, Object> resetPassword(ResetPasswordRequestModel requestModel) {
		final Map<String, Object> response = checkAndUpdatePassword(requestModel.getUserName(), null,
				requestModel.getNewPassword(), true);
		return response;
	}

	private Map<String, Object> checkAndUpdatePassword(String userName, String oldPassword, String newPassword,
			boolean canChekOldPassword) {
		final Map<String, Object> response = new HashMap<>();
		response.put("success", false);

		List<UserLogin> userLoginList = userLoginRepository.findByUserName(userName);
		if (userLoginList != null && !userLoginList.isEmpty()) {
			UserLogin user = userLoginList.get(0);
			if (!canChekOldPassword || (canChekOldPassword && CommonUtils.equals(user.getPassword(), oldPassword))) {
				updatePassword(newPassword, response, user);
			} else {
				response.put("message", "Old and new password does not match.");
			}
		} else {
			response.put("message", "Username not match.");
		}
		return response;
	}

	private void updatePassword(String newPassword, final Map<String, Object> response, UserLogin user) {
		user.setPassword(newPassword);
		userLoginRepository.saveAndFlush(user);
		response.put("success", true);
		response.put("message", "Password changed successfully.");
	}
}
