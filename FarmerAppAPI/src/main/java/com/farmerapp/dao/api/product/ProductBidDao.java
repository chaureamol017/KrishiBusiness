/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.dao.api.product;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.farmerapp.entity.ProductBid;

/**
 *
 * @author Amol
 */
@Repository
public interface ProductBidDao extends JpaRepository<ProductBid, String> {
    
    @Query("SELECT pb FROM ProductBid AS pb WHERE pb.productId.productId = :productId")
    public List<ProductBid> getProductBidByProduct(@Param("productId") String productId);
    
//    @Query("SELECT COUNT(pb.productBidId)FROM ProductBid AS pb WHERE pb.productId.productId = :productId")
//    public Number getProductBidCountByUser(@Param("userId") String userId);
}
