/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.FarmerAppAPI.dao;

import com.farmerapp.FarmerAppAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Amol
 */
public interface UserDao extends JpaRepository<User, String> {

}
