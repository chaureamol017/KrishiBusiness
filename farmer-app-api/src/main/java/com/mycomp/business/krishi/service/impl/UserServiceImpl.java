/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.impl;

import com.mycomp.business.krishi.dao.api.UserDao;
import com.mycomp.business.krishi.dao.api.UserLoginDao;
import com.mycomp.business.krishi.entity.User;
import com.mycomp.business.krishi.entity.UserLogin;
import com.mycomp.business.krishi.service.api.UserService;
import com.mycomp.business.krishi.service.api.adaptor.SignupRequestToUserAdaptor;
import com.mycomp.business.krishi.service.api.adaptor.SignupRequestToUserLoginAdaptor;
import com.mycomp.business.krishi.service.api.adaptor.UserModelAdaptor;
import com.mycomp.business.krishi.service.api.model.SignupRequestModel;
import com.mycomp.business.krishi.service.api.model.UserModel;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired private UserDao userDao;
	@Autowired private UserLoginDao userLoginDao;
	
	@Override
	public UserModel saveUser(SignupRequestModel signupRequest) {
		User user = SignupRequestToUserAdaptor.toEntityMinimal(signupRequest);
		userDao.saveAndFlush(user);
		
		UserModel model = UserModelAdaptor.toServiceModel(user);

		return model;
	}

	@Override
	public UserModel updateUser(UserModel userModel) {
		Optional<User> optionalUser = userDao.findById(userModel.getUserId());
		if (optionalUser.isPresent()) {
			User user = UserModelAdaptor.updateEntity(userModel, optionalUser.get());
			userDao.saveAndFlush(user);
			
			return UserModelAdaptor.toServiceModel(user);
		}
		return null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		List<User> users = userDao.findAll();
		List<UserModel> models = UserModelAdaptor.toServiceModel(users);
		
		return models;
	}

	@Override
	public UserModel getUser(Long userId) {
		try {
			User user = userDao.getOne(userId);
			UserModel model = UserModelAdaptor.toServiceModel(user);
			
			return model;
		} catch(EntityNotFoundException e) {
			
		}
		return null;
	}

	@Override
	public Boolean deleteUser(Long userId) {
		try {
			userDao.deleteById(userId);
			
			return true;
		} catch(IllegalArgumentException e) {
			
		}
		return false;
	}

	@Override
	public UserModel signupUser(SignupRequestModel requestModel) {
		UserModel model = saveUser(requestModel);
		
		requestModel.setUserId(model.getUserId());
		UserLogin userLogin = SignupRequestToUserLoginAdaptor.toEntityMinimal(requestModel);
		userLoginDao.saveAndFlush(userLogin);

		return model;
	}

}
