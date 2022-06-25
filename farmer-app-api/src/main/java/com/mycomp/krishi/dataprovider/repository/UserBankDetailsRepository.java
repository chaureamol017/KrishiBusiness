/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.dataprovider.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycomp.krishi.persistence.entity.UserBankDetails;

/**
 *
 * @author Amol
 */
@Repository
public interface UserBankDetailsRepository extends JpaRepository<UserBankDetails, Long> {

    List<UserBankDetails> findByUserId(Long userId);

//    @Query("SELECT ubd FROM UserBankDetails AS ubd WHERE ubd.userId.userId = :userId")
//    public List<UserBankDetails> findUserBankDetailsByUser(@Param("userId") Long userId);
}
