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

import com.mycomp.krishi.persistence.entity.FarmerProduct;

/**
 *
 * @author Amol
 */
@Repository
public interface FarmerProductRepository extends JpaRepository<FarmerProduct, Long> {

	List<FarmerProduct> findByProductId(Long productId);

	List<FarmerProduct> findByProductIdAndUserId(Long productId, Long userId);

	List<FarmerProduct> findByProductIdAndUserIdAndSold(Long productId, Long userId, boolean sold);

	List<FarmerProduct> findByUserId(Long userId);

	List<FarmerProduct> findByUserIdAndSold(Long userId, boolean sold);


//	@Query(value = "select * from farmer_product", nativeQuery = true)
//	public List<FarmerProduct> getFarmerProductByNativeQuery();
//
//	@Query("SELECT fp FROM FarmerProduct fp WHERE fp.productId = :productId ")
//	public List<FarmerProduct> getFarmerProductsByProductId(@Param("productId") Long productId);
//
//	@Query("SELECT fp FROM FarmerProduct fp WHERE fp.productId = :productId AND fp.userId = :userId ")
//	public List<FarmerProduct> getFarmerProductsByProductIdAndUserId(@Param("productId") Long productId,
//			@Param("userId") Long userId);
//
//	@Query("SELECT fp FROM FarmerProduct fp WHERE fp.productId = :productId AND fp.userId = :userId AND fp.sold  = :sold")
//	public List<FarmerProduct> getFarmerProductsByProductIdUserIdAndSold(@Param("productId") Long productId,
//			@Param("userId") Long userId, @Param("sold") boolean sold);
//
//	@Query("SELECT fp FROM FarmerProduct fp WHERE fp.userId = :userId ")
//	public List<FarmerProduct> getFarmerProductsByUserId(@Param("userId") Long userId);
//
//	@Query("SELECT fp FROM FarmerProduct fp WHERE fp.userId = :userId AND fp.sold  = :sold")
//	public List<FarmerProduct> getFarmerProductsByUserIdAndSold(@Param("userId") Long userId, @Param("sold") boolean sold);

}
