/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.controller;

import com.common.operations.CommonUtils;
import com.farmerapp.common.response.ApiResponse;
import com.farmerapp.entity.User;
import com.farmerapp.service.api.user.UserService;
import com.farmerapp.web.model.AddressDetaislRequestParams;
import com.farmerapp.web.model.BankDetaislRequestParams;
import com.farmerapp.web.model.ChangePasswordRequestParams;
import com.farmerapp.web.model.SignupRequestParams;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Amol
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userServiceObj;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        User tempuser = userServiceObj.saveUser(user);
        if (tempuser != null) {
            return new ResponseEntity<>(tempuser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(tempuser, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        User tempuser = userServiceObj.updateUser(user);
        if (tempuser != null) {
            return new ResponseEntity<>(tempuser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(tempuser, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllProduct() {
        List<User> users = userServiceObj.getAllUsers();
        if (users != null) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
        }
    }

    /*
    * To do: use Optionnal<E>
     */
    @GetMapping("/byid")
    public ResponseEntity<User> getUser(@RequestParam(name = "id") String id) {
        User user = userServiceObj.getUser(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam(name = "id") String id) {
        userServiceObj.deleteUser(id);
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signupUser(@RequestBody SignupRequestParams requestParams) {
        ApiResponse responseObj = userServiceObj.signupUser(requestParams);
        if (CommonUtils.checkIfNotNull(responseObj)) {
            return new ResponseEntity<>(responseObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseObj, HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping("/changepassword")
    public ResponseEntity<ApiResponse> changePassword(@RequestBody ChangePasswordRequestParams requestParams) {
        ApiResponse responseObj = userServiceObj.changePassword(requestParams);
        if (CommonUtils.checkIfNotNull(responseObj)) {
            return new ResponseEntity<>(responseObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseObj, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<ApiResponse> validateUserByEmailAndPassword(@RequestParam(value = "emailid") String emailId, @RequestParam(value = "password") String password) {
        ApiResponse responseObj = userServiceObj.validateUserByEmailAndPassword(emailId, password);

        return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }

    @PutMapping("/bankdetails")
    public ResponseEntity<ApiResponse> saveBankDetails(@RequestBody BankDetaislRequestParams requestParams) {
        ApiResponse responseObj = userServiceObj.saveBankDetails(requestParams);

        if (CommonUtils.checkIfNotNull(responseObj)) {
            return new ResponseEntity<>(responseObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseObj, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/bankdetails")
    public ResponseEntity<ApiResponse> getBankDetails(@RequestParam(value = "userId") String userId) {
        ApiResponse responseObj = userServiceObj.getABankDetails(userId);
        if (responseObj != null) {
            return new ResponseEntity<>(responseObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseObj, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addressdetails")
    public ResponseEntity<ApiResponse> saveAddressDetails(@RequestBody AddressDetaislRequestParams requestParams) {
        ApiResponse responseObj = userServiceObj.saveAddressDetails(requestParams);

        if (CommonUtils.checkIfNotNull(responseObj)) {
            return new ResponseEntity<>(responseObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseObj, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/addressdetails")
    public ResponseEntity<ApiResponse> getAddressDetails(@RequestParam(value = "userId") String userId) {
        ApiResponse responseObj = userServiceObj.getAddressDetails(userId);
        if (responseObj != null) {
            return new ResponseEntity<>(responseObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseObj, HttpStatus.NOT_FOUND);
        }
    }

}
