/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.user.service;

import java.util.Map;

import com.mycomp.krishi.user.model.ChangePasswordRequestModel;
import com.mycomp.krishi.user.model.ResetPasswordRequestModel;
import com.mycomp.krishi.user.model.SignupRequestModel;
import com.mycomp.krishi.user.model.UserModel;


/**
 *
 * @author Amol
 */
public interface UserLoginSignupService {

    public Boolean signupUser(SignupRequestModel signupRequest);
    
    public UserModel validateUserByUserNameAndPassword(String userName, String password);
    
    public Map<String, Object> changePassword(ChangePasswordRequestModel requestParams);

	public Map<String, Object> resetPassword(ResetPasswordRequestModel model);
    
}
