/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.FarmerAppAPI.service;

import com.farmerapp.FarmerAppAPI.entity.User;
import com.farmerapp.FarmerAppAPI.entity.params.AddressDetaislRequestParams;
import com.farmerapp.FarmerAppAPI.entity.params.BankDetaislRequestParams;
import com.farmerapp.FarmerAppAPI.entity.params.ChangePasswordRequestParams;
import com.farmerapp.common.implementation.response.ApiResponse;
import com.farmerapp.FarmerAppAPI.entity.params.SignupRequestParams;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Amol
 */
public interface UserService {

    public User saveUser(User user);

    public User updateUser(User user);

    public List<User> getAllUsers();

    public User getUser(String id);

    public JSONObject getUserFormated(String id);

    void deleteUser(String id);

    public ApiResponse signupUser(SignupRequestParams requestParams);
    
    public ApiResponse validateUserByEmailAndPassword(String emailId, String password);
    
    public ApiResponse changePassword(ChangePasswordRequestParams requestParams);
    
    public ApiResponse saveBankDetails(BankDetaislRequestParams requestParams);

    public ApiResponse getABankDetails(String userId);
    
    public ApiResponse saveAddressDetails(AddressDetaislRequestParams requestParams);

    public ApiResponse getAddressDetails(String userId);
    
    public JSONObject populateUserJson(User user);

    public JSONObject populatUserJson(User user, JSONObject detailsJson);
    
    public JSONObject populatUserJsonAsBuyer(User user, JSONObject detailsJson);
}
