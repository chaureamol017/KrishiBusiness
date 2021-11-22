/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.impl;

import com.common.operations.CommonUtils;
import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.dao.api.UserLoginDao;
import com.mycomp.business.krishi.entity.User;
import com.mycomp.business.krishi.entity.UserLogin;
import com.mycomp.business.krishi.service.api.UserLoginSignupService;
import com.mycomp.business.krishi.service.api.UserService;
import com.mycomp.business.krishi.service.api.adaptor.SignupRequestToUserLoginAdaptor;
import com.mycomp.business.krishi.service.api.adaptor.UserModelAdaptor;
import com.mycomp.business.krishi.service.api.model.ChangePasswordRequestModel;
import com.mycomp.business.krishi.service.api.model.ResetPasswordRequestModel;
import com.mycomp.business.krishi.service.api.model.SignupRequestModel;
import com.mycomp.business.krishi.service.api.model.UserModel;

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
	private ModelAdaptor<SignupRequestModel, UserLogin> modelAdaptor = SignupRequestToUserLoginAdaptor.INSTANCE;
	private ModelAdaptor<UserModel, User> userModelAdaptor = UserModelAdaptor.INSTANCE;

	@Autowired private UserService userService;
	@Autowired private UserLoginDao userLoginDao;

	@Override
	public Boolean signupUser(SignupRequestModel signupRequest) {
		UserModel userModel = userService.saveUser(signupRequest);

		signupRequest.setUserId(userModel.getUserId());
		UserLogin userLogin = modelAdaptor.toEntityMinimal(signupRequest);
		userLoginDao.save(userLogin);

		return true;
	}

	@Override
	public UserModel validateUserByUserNameAndPassword(String userName, String password) {

		List<UserLogin> userLoginList = userLoginDao.validateUser(userName, password);
		if (userLoginList != null && !userLoginList.isEmpty()) {
			User user = userLoginList.get(0).getUser();

			return userModelAdaptor.toServiceModel(user);
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

		List<UserLogin> userLoginList = userLoginDao.getByuserName(userName);
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
		userLoginDao.saveAndFlush(user);
		response.put("success", true);
		response.put("message", "Password changed successfully.");
	}
}
