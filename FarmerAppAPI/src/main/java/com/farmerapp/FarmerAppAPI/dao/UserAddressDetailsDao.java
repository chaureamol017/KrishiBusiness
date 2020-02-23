/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.FarmerAppAPI.dao;

import com.farmerapp.FarmerAppAPI.entity.User;
import com.farmerapp.FarmerAppAPI.entity.UserAddressDetails;
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
public interface UserAddressDetailsDao extends JpaRepository<UserAddressDetails, String> {
    @Query("SELECT uad FROM UserAddressDetails AS uad WHERE uad.userId.userId = :userId")
    public List<UserAddressDetails> findUserAddressDetailsByUser(@Param("userId") String userId);
}
