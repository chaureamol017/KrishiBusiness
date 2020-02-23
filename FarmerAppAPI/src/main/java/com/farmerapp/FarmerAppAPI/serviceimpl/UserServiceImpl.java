/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.FarmerAppAPI.serviceimpl;

import com.common.operations.CommonUtils;
import com.farmerapp.FarmerAppAPI.dao.UserAddressDetailsDao;
import com.farmerapp.FarmerAppAPI.dao.UserBankDetailsDao;
import com.farmerapp.FarmerAppAPI.dao.UserDao;
import com.farmerapp.FarmerAppAPI.dao.UserLoginDao;
import com.farmerapp.FarmerAppAPI.entity.User;
import com.farmerapp.FarmerAppAPI.entity.UserAddressDetails;
import com.farmerapp.FarmerAppAPI.entity.UserBankDetails;
import com.farmerapp.FarmerAppAPI.entity.UserLogin;
import com.farmerapp.FarmerAppAPI.entity.params.AddressDetaislRequestParams;
import com.farmerapp.FarmerAppAPI.entity.params.BankDetaislRequestParams;
import com.farmerapp.FarmerAppAPI.entity.params.ChangePasswordRequestParams;
import com.farmerapp.FarmerAppAPI.service.UserService;
import com.farmerapp.common.constants.Constants;
import com.farmerapp.common.implementation.response.ApiResponse;
import com.farmerapp.FarmerAppAPI.entity.params.SignupRequestParams;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDaoObj;
    @Autowired
    private UserLoginDao userLoginDaoObj;
    @Autowired
    private UserBankDetailsDao userBankDetailsDaoObj;
    @Autowired
    private UserAddressDetailsDao userAddressDetailsDaoObj;

    @Override
    public User saveUser(User user) {
        return userDaoObj.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userDaoObj.saveAndFlush(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoObj.findAll();
    }

    @Override
    public User getUser(String id) {
        return userDaoObj.getOne(id);
    }

    @Override
    public JSONObject getUserFormated(String id) {
        User user = getUser(id);
        return populateUserJson(user);
    }

    @Override
    public void deleteUser(String id) {
        userDaoObj.deleteById(id);
    }

    @Override
    public ApiResponse signupUser(SignupRequestParams requestParams) {
        ApiResponse responseObj = new ApiResponse();

        String registrationFor = requestParams.getRegistrationFor();
        String firstName = requestParams.getFirstName();
        String moddleName = requestParams.getMiddleName();
        String lastName = requestParams.getLastName();
        String emailID = requestParams.getEmailId();
        String mobile = requestParams.getMobile();
        String password = requestParams.getPassword();

        User user = new User();

        user.setRegistrationFor(registrationFor);
        user.setFirstName(firstName);
        user.setMiddleName(moddleName);
        user.setLastName(lastName);
        user.setEmailId(emailID);
        user.setMobile(mobile);

        UserLogin userLogin = new UserLogin();

        userLogin.setUser(user);
        userLogin.setEmailID(emailID);
        userLogin.setPassword(password);

        userDaoObj.save(user);

        userLoginDaoObj.save(userLogin);
        responseObj.setSuccess(true);
        return responseObj;
    }

    @Override
    public ApiResponse validateUserByEmailAndPassword(String emailId, String password) {
        ApiResponse apiResponse = new ApiResponse();

        List<UserLogin> userLoginList = userLoginDaoObj.validateUser(emailId, password);
        if (userLoginList != null && !userLoginList.isEmpty()) {
            apiResponse.setSuccess(true);
            User user = userLoginList.get(0).getUser();

            JSONObject detailsJson = populateUserJson(user);
            apiResponse.setData(detailsJson.toString());
        } else {
        }
        return apiResponse;
    }

    @Override
    public ApiResponse changePassword(ChangePasswordRequestParams requestParams) {
        ApiResponse apiResponse = new ApiResponse();

        String userId = requestParams.getUserId();
        List<UserLogin> userLoginList
                = userLoginDaoObj.getByUserId(userId);

        if (userLoginList != null && !userLoginList.isEmpty()) {
            JSONObject jObj = new JSONObject();
            UserLogin user = userLoginList.get(0);
            if (CommonUtils.equals(user.getPassword(), requestParams.getOldPassword())) {
                user.setPassword(requestParams.getNewPassword());

                userLoginDaoObj.saveAndFlush(user);

                apiResponse.setSuccess(true);
                jObj.put("message", "Passord changed successfully.");
            } else {
                jObj.put("message", "Passord does not match.");
            }
            apiResponse.setData(jObj.toString());

        }
        return apiResponse;
    }

    @Override
    public ApiResponse saveAddressDetails(AddressDetaislRequestParams requestParams) {
        ApiResponse apiResponse = new ApiResponse();

        String userAddressDetailsId = requestParams.getUserAddressDetailsId();
        String addressLine1 = requestParams.getAddressLine1();
        String addressLine2 = requestParams.getAddressLine2();
        String locality = requestParams.getLocality();
        String cityName = requestParams.getCityName();
        String tahsilName = requestParams.getTahsilName();
        String stateName = requestParams.getStateName();
        String pincode = requestParams.getPincode();

        UserAddressDetails userAddressDetails = null;

        if (!CommonUtils.isNullOrEmpty(userAddressDetailsId)) {
            userAddressDetails = userAddressDetailsDaoObj.getOne(userAddressDetailsId);
        }
        if (CommonUtils.checkIfNull(userAddressDetails)) {
            userAddressDetails = new UserAddressDetails();
            String userId = requestParams.getUserId();
            User user = getUser(userId);
            userAddressDetails.setUserId(user);
        }

        userAddressDetails.setAddressLine1(addressLine1);
        userAddressDetails.setAddressLine2(addressLine2);
        userAddressDetails.setLocality(locality);
        userAddressDetails.setCityName(cityName);
        userAddressDetails.setTahsilName(tahsilName);
        userAddressDetails.setStateName(stateName);
        userAddressDetails.setPincode(pincode);

        userAddressDetails = userAddressDetailsDaoObj.save(userAddressDetails);

        JSONObject addressDetailsJson = prepareAddressDetailsJson(userAddressDetails);

        apiResponse.setSuccess(true);
        apiResponse.setData(addressDetailsJson.toString());

        return apiResponse;
    }

    @Override
    public ApiResponse getAddressDetails(String userId) {
        ApiResponse apiResponse = new ApiResponse();
        JSONObject detailsJson = new JSONObject();

        List<UserAddressDetails> bankDetailsList = userAddressDetailsDaoObj.findUserAddressDetailsByUser(userId);

        if (CommonUtils.checkIfListNotEmpty(bankDetailsList)) {
            UserAddressDetails addressDetails = bankDetailsList.get(0);
            detailsJson = prepareAddressDetailsJson(addressDetails);
            apiResponse.setSuccess(true);
            apiResponse.setData(detailsJson.toString());
        }

        return apiResponse;
    }

    @Override
    public ApiResponse saveBankDetails(BankDetaislRequestParams requestParams) {
        ApiResponse responseObj = new ApiResponse();

        String userBankDetailsId = requestParams.getUserBankDetailsId();
        String bankName = requestParams.getBankName();
        String branchName = requestParams.getBranchName();
        String ifscCode = requestParams.getIfscCode();

        UserBankDetails bankDetails = null;

        if (!CommonUtils.isNullOrEmpty(userBankDetailsId)) {
            bankDetails = userBankDetailsDaoObj.getOne(userBankDetailsId);
        }

        if (CommonUtils.checkIfNull(bankDetails)) {

            String userId = requestParams.getUserId();
            User user = getUser(userId);
            bankDetails = new UserBankDetails();
            bankDetails.setUserId(user);
        }

        bankDetails.setBankName(bankName);
        bankDetails.setBranchName(branchName);
        bankDetails.setIfscCode(ifscCode);

        bankDetails = userBankDetailsDaoObj.saveAndFlush(bankDetails);

        JSONObject bankDetailsJson = prepareBankDetailsJson(bankDetails);

        responseObj.setSuccess(true);
        responseObj.setData(bankDetailsJson.toString());

        return responseObj;
    }

    @Override
    public ApiResponse getABankDetails(String userId) {
        ApiResponse responseObj = new ApiResponse();

        List<UserBankDetails> bankDetailsList = userBankDetailsDaoObj.findUserBankDetailsByUser(userId);

        if (CommonUtils.checkIfListNotEmpty(bankDetailsList)) {
            UserBankDetails bankDetails = bankDetailsList.get(0);
            JSONObject detailsJson = prepareBankDetailsJson(bankDetails);
            responseObj.setData(detailsJson.toString());
        }

        responseObj.setSuccess(true);
        return responseObj;
    }

    @Override
    public JSONObject populateUserJson(User user) {
        JSONObject detailsJson = new JSONObject();

        if (CommonUtils.checkIfNotNull(user)) {
            populatUserJson(user, detailsJson);
            String registrationFor = user.getRegistrationFor();
            String middleName = user.getMiddleName();
            String emailId = user.getEmailId();

            detailsJson.put("registrationFor", registrationFor);
            detailsJson.put("middleName", middleName);
            detailsJson.put("emailId", emailId);
        }

        return detailsJson;
    }

    @Override
    public JSONObject populatUserJson(User user, JSONObject detailsJson) {
        if (!CommonUtils.checkIfNotNull(detailsJson)) {
            detailsJson = new JSONObject();
        }
        if (CommonUtils.checkIfNotNull(user)) {
            String userId = user.getUserId();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();

            detailsJson.put("userId", userId);
            detailsJson.put("firstName", firstName);
            detailsJson.put("lastName", lastName);
        }

        return detailsJson;
    }

    @Override
    public JSONObject populatUserJsonAsBuyer(User user, JSONObject detailsJson) {
        if (!CommonUtils.checkIfNotNull(detailsJson)) {
            detailsJson = new JSONObject();
        }

        if (CommonUtils.checkIfNotNull(user)) {
            String userId = user.getUserId();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();

            detailsJson.put("buyerUserId", userId);
            detailsJson.put("buyerFirstName", firstName);
            detailsJson.put("buyerLastName", lastName);
        }

        return detailsJson;
    }

    private JSONObject prepareBankDetailsJson(UserBankDetails bankDetails) {
        JSONObject detailsJson = new JSONObject();

        if (CommonUtils.checkIfNotNull(bankDetails)) {
            User user = bankDetails.getUserId();
            String userBankDetailsId = bankDetails.getUserBankDetailsId();
            String bankName = bankDetails.getBankName();
            String branchName = bankDetails.getBranchName();
            String ifscCode = bankDetails.getIfscCode();

            populatUserJson(user, detailsJson);
            detailsJson.put("userBankDetailsId", userBankDetailsId);
            detailsJson.put("bankName", bankName);
            detailsJson.put("branchName", branchName);
            detailsJson.put("ifscCode", ifscCode);
        }

        return detailsJson;
    }

    private JSONObject prepareAddressDetailsJson(UserAddressDetails addressDetails) {
        JSONObject detailsJson = new JSONObject();

        if (CommonUtils.checkIfNotNull(addressDetails)) {
            User user = addressDetails.getUserId();
            String userAddressDetailsId = addressDetails.getUserAddressDetailsId();
            String addressLine1 = addressDetails.getAddressLine1();
            String addressLine2 = addressDetails.getAddressLine2();
            String locality = addressDetails.getLocality();
            String cityName = addressDetails.getCityName();
            String tahsilName = addressDetails.getTahsilName();
            String stateName = addressDetails.getStateName();
            String pincode = addressDetails.getPincode();

            populatUserJson(user, detailsJson);
            detailsJson.put("userAddressDetailsId", userAddressDetailsId);
            detailsJson.put("addressLine1", addressLine1);
            detailsJson.put("addressLine2", addressLine2);
            detailsJson.put("locality", locality);
            detailsJson.put("cityName", cityName);
            detailsJson.put("tahsilName", tahsilName);
            detailsJson.put("locality", stateName);
            detailsJson.put("pincode", pincode);
        }

        return detailsJson;
    }
}
