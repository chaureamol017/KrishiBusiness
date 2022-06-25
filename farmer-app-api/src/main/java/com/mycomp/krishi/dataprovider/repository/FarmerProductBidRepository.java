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

/**
 *
 * @author Amol
 */
@Repository
public interface FarmerProductBidRepository extends JpaRepository<FarmerProductBid, Long> {

	List<FarmerProductBid> findByFarmerProductId(Long farmerProductId);

	List<FarmerProductBid> findByProductIdAndBuyerUserId(Long productId, Long buyerUserId);
	
//    @Query("SELECT fpb FROM FarmerProductBid AS fpb WHERE fpb.farmerProductId = :farmerProductId")
//    List<FarmerProductBid> getFarmerProductBidsByFarmerProductId(@Param("farmerProductId") Long farmerProductId);
//
//    @Query("SELECT fpb FROM FarmerProductBid AS fpb INNER JOIN fpb.farmerProduct AS fp WHERE fp.productId = :productId AND fpb.buyerUserId = :buyerUserId")
//	List<FarmerProductBid> getFarmerProductBidsByProductIdAndBuyerUserId(@Param("productId") Long productId, @Param("buyerUserId") Long buyerUserId);

}
