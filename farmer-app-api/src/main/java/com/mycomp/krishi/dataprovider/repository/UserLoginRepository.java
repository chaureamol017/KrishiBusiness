/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.dataprovider.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycomp.krishi.persistence.entity.UserLogin;

/**
 *
 * @author Amol
 */
@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    
    @Query("SELECT ul FROM UserLogin ul WHERE ul.user.emailId = :userName AND ul.password = :password")
    public List<UserLogin> validateUser(@Param("userName") String emailId, @Param("password") String password);

    @Query("SELECT ul FROM UserLogin ul WHERE ul.user.userId = :userId")
    public List<UserLogin> getByUserId(@Param("userId") Long userId);

    public List<UserLogin> findByUserName(String userName);
    
//    @Query("SELECT ul FROM UserLogin ul WHERE ul.userName = :userName")
//    public List<UserLogin> getByuserName(@Param("userName") String userName);
}
