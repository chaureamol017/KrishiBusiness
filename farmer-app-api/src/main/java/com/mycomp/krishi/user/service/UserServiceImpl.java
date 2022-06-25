/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.user.service;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.dataprovider.repository.UserLoginRepository;
import com.mycomp.krishi.dataprovider.repository.UserRepository;
import com.mycomp.krishi.persistence.entity.User;
import com.mycomp.krishi.persistence.entity.UserLogin;
import com.mycomp.krishi.user.adapter.SignupRequestToUserAdapter;
import com.mycomp.krishi.user.adapter.SignupRequestToUserLoginAdapter;
import com.mycomp.krishi.user.adapter.UserModelAdapter;
import com.mycomp.krishi.user.model.SignupRequestModel;
import com.mycomp.krishi.user.model.UserModel;

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
	private ModelAdapter<UserModel, User> modelAdapter = UserModelAdapter.INSTANCE;
	private ModelAdapter<SignupRequestModel, UserLogin> userLoginAdapter = SignupRequestToUserLoginAdapter.INSTANCE;

	@Autowired private UserRepository userRepository;
	@Autowired private UserLoginRepository userLoginRepository;
	
	@Override
	public UserModel saveUser(SignupRequestModel signupRequest) {
		User user = SignupRequestToUserAdapter.INSTANCE.toEntityMinimal(signupRequest);
		userRepository.saveAndFlush(user);

		return modelAdapter.toModel(user);
	}

	@Override
	public UserModel updateUser(UserModel userModel) {
		Optional<User> optionalUser = userRepository.findById(userModel.getUserId());
		if (optionalUser.isPresent()) {
			User user = UserModelAdapter.INSTANCE.updateEntity(userModel, optionalUser.get());
			userRepository.saveAndFlush(user);
			
			return modelAdapter.toModel(user);
		}
		return null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserModel> models = modelAdapter.toModel(users);
		
		return models;
	}

	@Override
	public UserModel getUser(Long userId) {
		try {
			User user = userRepository.getOne(userId);
			UserModel model = modelAdapter.toModel(user);
			
			return model;
		} catch(EntityNotFoundException e) {
			
		}
		return null;
	}

	@Override
	public Boolean deleteUser(Long userId) {
		try {
			userRepository.deleteById(userId);
			
			return true;
		} catch(IllegalArgumentException e) {
			
		}
		return false;
	}

	@Override
	public UserModel signupUser(SignupRequestModel requestModel) {
		UserModel model = saveUser(requestModel);
		
		requestModel.setUserId(model.getUserId());
		UserLogin userLogin = userLoginAdapter.toEntityMinimal(requestModel);
		userLoginRepository.saveAndFlush(userLogin);

		return model;
	}

}
