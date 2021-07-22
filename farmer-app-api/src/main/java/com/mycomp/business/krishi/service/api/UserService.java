/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.api;

import com.mycomp.business.krishi.service.api.model.SignupRequestModel;
import com.mycomp.business.krishi.service.api.model.UserModel;

import java.util.List;

/**
 *
 * @author Amol
 */
public interface UserService {

    UserModel saveUser(SignupRequestModel signupRequest);

    UserModel updateUser(UserModel userModel);

    List<UserModel> getAllUsers();

    UserModel getUser(Long id);

    Boolean deleteUser(Long id);

	UserModel signupUser(SignupRequestModel model);
}
