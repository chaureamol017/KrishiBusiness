/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.api;

import java.util.Map;

import com.mycomp.business.krishi.service.api.model.ChangePasswordRequestModel;
import com.mycomp.business.krishi.service.api.model.ResetPasswordRequestModel;
import com.mycomp.business.krishi.service.api.model.SignupRequestModel;
import com.mycomp.business.krishi.service.api.model.UserModel;


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
