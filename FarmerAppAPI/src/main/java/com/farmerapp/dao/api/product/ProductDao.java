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

import com.farmerapp.entity.Product;

/**
 *
 * @author Rahul
 */
@Repository
public interface ProductDao extends JpaRepository<Product, String> {

    @Query("from Product")
    public List<Product> getProductByJPQ();

    @Query(value = "select * from product", nativeQuery = true)
    public List<Product> getProductByNativeQuery();

    @Query("SELECT p FROM Product p WHERE p.productName = :productname")
    public List<Product> findProductByName(@Param("productname") String productName);

    @Query("SELECT p FROM Product p WHERE p.farmer.userId = :userId AND p.soldSuccess = :isSold")
    public List<Product> findProductByUser(@Param("userId") String userId, @Param("isSold") boolean isSold);

    @Query("SELECT p FROM Product p WHERE p.soldSuccess = :isSold")
    public List<Product> findAllProductsBySoldStatus(@Param("isSold") boolean isSold);

//    @Query("SELECT COUNT(p.productId) FROM Product p WHERE p.farmer.userId = :userId")
//    public Number getProductCountByUser(@Param("userId") String userId);
}
