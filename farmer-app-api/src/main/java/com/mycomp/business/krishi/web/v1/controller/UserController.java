/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.web.v1.controller;

import com.mycomp.business.krishi.api.adapter.ResponseEntityAdaptor;
import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.UserService;
import com.mycomp.business.krishi.service.api.model.UserModel;
import com.mycomp.business.krishi.web.v1.model.UserWeb;
import com.mycomp.business.krishi.web.v1.adaptor.UserWebAdaptor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Amol
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/user")
public class UserController {
    private WebAdaptor<UserWeb, UserModel> webAdaptor = UserWebAdaptor.INSTANCE;
    private ResponseEntityAdaptor<UserWeb, UserModel> responseEntityAdaptor = new ResponseEntityAdaptor<>(webAdaptor);

    @Autowired private UserService userService;

    @PutMapping("/update")
    public ResponseEntity<UserWeb> update(@RequestBody UserWeb userWeb) {
    	UserModel userModel = webAdaptor.toServiceModel(userWeb);
        UserModel updatedUser = userService.updateUser(userModel);
        
        return responseEntityAdaptor.createResponseEntity(updatedUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserWeb>> getAllUsers() {
        List<UserModel> userModels = userService.getAllUsers();

        return responseEntityAdaptor.createResponseEntity(userModels);
    }

    /*
    * To do: use Optionnal<E>
     */
    @GetMapping("/byid/{userId}")
    public ResponseEntity<UserWeb> getUser(@PathVariable(name = "userId") Long userId) {
        UserModel userModel = userService.getUser(userId);

        return responseEntityAdaptor.createResponseEntity(userModel);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(name = "userId") Long userId) {
    	Boolean success = userService.deleteUser(userId);
    	return new ResponseEntity<>(success, HttpStatus.OK);
    }

//    @PostMapping("/signup")
//    public ResponseEntity<UserWeb> signupUser(@RequestBody SignupRequestParams requestParams) {
//    	SignupRequestModel model = SignupRequestParamsAdaptor.toServiceModel(requestParams);
//    	UserModel userModel = userService.signupUser(model);
//        
//        return createResponseEntity(userModel);
//    }

}
