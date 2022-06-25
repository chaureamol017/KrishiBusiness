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

import com.mycomp.krishi.persistence.entity.FarmerProductBid;
import com.mycomp.krishi.persistence.entity.FarmerProductBuyerMap;

/**
 *
 * @author Amol
 */
@Repository
public interface FarmerProductBuyerMapRepository extends JpaRepository<FarmerProductBuyerMap, Long> {

    List<FarmerProductBid> findBidByProductId(Long farmerProductId);

    List<FarmerProductBid> getFarmerProductBidByBuyerUserId(Long buyerUserId);
	
    
//    @Query("SELECT fpbm FROM FarmerProductBuyerMap AS fpbm WHERE fpbm.farmerProductId = :farmerProductId")
//    public List<FarmerProductBid> getFarmerProductBidByProductId(@Param("farmerProductId") Long farmerProductId);
//
//    @Query("SELECT fpbm FROM FarmerProductBuyerMap AS fpbm WHERE fpbm.buyerUserId = :buyerUserId")
//    public List<FarmerProductBid> getFarmerProductBidByBuyerUserId(@Param("buyerUserId") Long buyerUserId);

}
