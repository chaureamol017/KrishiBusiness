/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.user.controller;

import com.mycomp.common.adapter.ResponseEntityAdapter;
import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.user.adapter.UserWebAdapter;
import com.mycomp.krishi.user.model.UserModel;
import com.mycomp.krishi.user.requests.UserWeb;
import com.mycomp.krishi.user.service.UserService;

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
    private WebAdapter<UserWeb, UserModel> webAdapter = UserWebAdapter.INSTANCE;
    private ResponseEntityAdapter<UserWeb, UserModel> responseEntityAdapter = new ResponseEntityAdapter<>(webAdapter);

    @Autowired private UserService userService;

    @PutMapping("/update")
    public ResponseEntity<UserWeb> update(@RequestBody UserWeb userWeb) {
    	UserModel userModel = webAdapter.toModel(userWeb);
        UserModel updatedUser = userService.updateUser(userModel);
        
        return responseEntityAdapter.createResponseEntity(updatedUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserWeb>> getAllUsers() {
        List<UserModel> userModels = userService.getAllUsers();

        return responseEntityAdapter.createResponseEntity(userModels);
    }

    /*
    * To do: use Optionnal<E>
     */
    @GetMapping("/byid/{userId}")
    public ResponseEntity<UserWeb> getUser(@PathVariable(name = "userId") Long userId) {
        UserModel userModel = userService.getUser(userId);

        return responseEntityAdapter.createResponseEntity(userModel);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(name = "userId") Long userId) {
    	Boolean success = userService.deleteUser(userId);
    	return new ResponseEntity<>(success, HttpStatus.OK);
    }


}
