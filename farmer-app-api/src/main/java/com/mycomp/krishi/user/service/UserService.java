/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.user.service;

import java.util.List;

import com.mycomp.krishi.user.model.SignupRequestModel;
import com.mycomp.krishi.user.model.UserModel;

/**
 *
 * @author Amol
 */
public interface UserService {

    UserModel saveUser(SignupRequestModel signupRequest) throws RuntimeException;

    UserModel updateUser(UserModel userModel);

    List<UserModel> getAllUsers();
    List<UserModel> getUsers(List<Long> userIds);

    UserModel getUser(Long id);

    Boolean deleteUser(Long id);

	UserModel signupUser(SignupRequestModel model);
}
