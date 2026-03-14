package com.mycomp.krishi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycomp.krishi.persistence.entity.FarmerProductBid;

import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface FarmerProductBidRepository extends JpaRepository<FarmerProductBid, Long> {
    List<FarmerProductBid> findByBuyerUserIdAndFarmerProductId(Long buyerUserId, Long farmerProductId);
    List<FarmerProductBid> findByFarmerProductId(Long farmerProductId);

    long countByBuyerUserId(Long buyerUserId);
    long countByBuyerUserIdAndAcceptedIsTrue(Long buyerUserId);

    List<FarmerProductBid> findByBuyerUserId(Long buyerUserId);
    List<FarmerProductBid> findByBuyerUserIdAndAcceptedIsTrue(Long buyerUserId);

    // All accepted bids (transactions)
    List<FarmerProductBid> findByAcceptedIsTrue();

    // Accepted bids for a specific farmer product
    @Query("SELECT fpb FROM FarmerProductBid fpb WHERE fpb.farmerProductId = :farmerProductId AND fpb.accepted = true")
    FarmerProductBid findAcceptedBidForProduct(@Param("farmerProductId") Long farmerProductId);

    @Query("SELECT COUNT(fpb) FROM FarmerProductBid fpb")
    long countAllBids();

    @Query("SELECT COUNT(fpb) FROM FarmerProductBid fpb WHERE fpb.accepted = true")
    long countAllAcceptedBids();

    // Date-range filter for buyer report
    @Query("SELECT fpb FROM FarmerProductBid fpb WHERE fpb.buyerUserId = :buyerUserId AND (:startDate IS NULL OR fpb.bidOn IS NULL OR fpb.bidOn >= :startDate) AND (:endDate IS NULL OR fpb.bidOn IS NULL OR fpb.bidOn <= :endDate)")
    List<FarmerProductBid> findByBuyerUserIdAndDateRange(@Param("buyerUserId") Long buyerUserId,
                                                          @Param("startDate") Date startDate,
                                                          @Param("endDate") Date endDate);

    @Modifying
    @Transactional
    @Query("UPDATE FarmerProductBid fpb SET fpb.accepted = :accepted, fpb.acceptedOn =:acceptedOn WHERE fpb.farmerProductBidId = :productBidId")
    int acceptBid(@Param("productBidId") Long productBidId, @Param("accepted") boolean accepted, @Param("acceptedOn") Date acceptedOn);

}

