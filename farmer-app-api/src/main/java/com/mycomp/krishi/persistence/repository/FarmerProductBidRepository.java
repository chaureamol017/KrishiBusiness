package com.mycomp.krishi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycomp.krishi.persistence.entity.FarmerProductBid;

@Repository
public interface FarmerProductBidRepository extends JpaRepository<FarmerProductBid, Long> {
}

