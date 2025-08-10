package com.mycomp.krishi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycomp.krishi.persistence.entity.FarmerProductBid;

import java.util.List;

@Repository
public interface FarmerProductBidRepository extends JpaRepository<FarmerProductBid, Long> {
    List<FarmerProductBid> findByBuyerUserIdAndFarmerProductId(Long buyerUserId, Long farmerProductId);
}

