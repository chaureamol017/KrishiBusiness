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

