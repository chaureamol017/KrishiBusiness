package com.mycomp.krishi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycomp.krishi.persistence.entity.FarmerProduct;

import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface FarmerProductRepository extends JpaRepository<FarmerProduct, Long> {
    List<FarmerProduct> findByUserId(Long userId);
    List<FarmerProduct> findByUserIdNot(Long userId);
    List<FarmerProduct> findByUserIdNotAndSoldIsFalseOrSoldIsNull(Long userId);

    // Date-range filter for seller report
    @Query("SELECT fp FROM FarmerProduct fp WHERE fp.userId = :userId AND (:startDate IS NULL OR fp.addedOn >= :startDate) AND (:endDate IS NULL OR fp.addedOn <= :endDate)")
    List<FarmerProduct> findByUserIdAndDateRange(@Param("userId") Long userId,
                                                  @Param("startDate") Date startDate,
                                                  @Param("endDate") Date endDate);

    // Search & Filter
    @Query("SELECT fp FROM FarmerProduct fp WHERE fp.userId <> :userId " +
           "AND (fp.sold IS NULL OR fp.sold = false) " +
           "AND (:category IS NULL OR fp.product.category = :category) " +
           "AND (:city IS NULL OR fp.city = :city) " +
           "AND (:search IS NULL OR fp.product.name LIKE CONCAT('%', :search, '%') OR fp.description LIKE CONCAT('%', :search, '%'))")
    List<FarmerProduct> searchProducts(@Param("userId") Long userId,
                                       @Param("category") String category,
                                       @Param("city") String city,
                                       @Param("search") String search);

    // All products (for admin)
    @Query("SELECT fp FROM FarmerProduct fp WHERE fp.sold = true")
    List<FarmerProduct> findAllSoldProducts();

    // Transactions: accepted bids with product info
    @Query("SELECT fp FROM FarmerProduct fp WHERE fp.sold = true AND fp.userId = :userId")
    List<FarmerProduct> findSoldByUserId(@Param("userId") Long userId);

    long countByUserId(Long userId);
    long countByUserIdAndSoldIsTrue(Long userId);
    long countByUserIdAndSoldIsFalseOrUserIdAndSoldIsNull(Long userId1, Long userId2);

    @Query("SELECT COUNT(fp) FROM FarmerProduct fp")
    long countAllProducts();

    @Query("SELECT COUNT(fp) FROM FarmerProduct fp WHERE fp.sold = true")
    long countAllSoldProducts();

    @Modifying
    @Transactional
    @Query("UPDATE FarmerProduct fp SET fp.sold = :sold, fp.soldOn =:soldOn WHERE fp.farmerProductId = :farmerProductId")
    int markSold(@Param("farmerProductId") Long farmerProductId, @Param("sold") boolean sold, @Param("soldOn") Date soldOn);
}

