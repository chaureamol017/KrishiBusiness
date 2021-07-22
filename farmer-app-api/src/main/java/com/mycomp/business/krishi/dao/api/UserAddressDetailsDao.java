/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.dao.api;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycomp.business.krishi.entity.UserAddressDetails;

/**
 *
 * @author Amol
 */
@Repository
public interface UserAddressDetailsDao extends JpaRepository<UserAddressDetails, Long> {
    @Query("SELECT uad FROM UserAddressDetails AS uad WHERE uad.userId = :userId")
    public List<UserAddressDetails> findUserAddressDetailsByUser(@Param("userId") Long userId);
}
