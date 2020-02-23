/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.FarmerAppAPI.dao;

import com.farmerapp.FarmerAppAPI.entity.User;
import com.farmerapp.FarmerAppAPI.entity.UserLogin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Amol
 */
@Repository
public interface UserLoginDao extends JpaRepository<UserLogin, String> {
    
    @Query("SELECT ul FROM UserLogin ul WHERE ul.user.emailId = :emailId AND ul.password = :password")
//    @Query("SELECT ul FROM UserLogin ul WHERE ul.emailID = :emailId AND ul.password = :password")
    public List<UserLogin> validateUser(@Param("emailId") String emailId, @Param("password") String password);

    @Query("SELECT ul FROM UserLogin ul WHERE ul.user.userId = :userId")
    public List<UserLogin> getByUserId(@Param("userId") String userId);
}
