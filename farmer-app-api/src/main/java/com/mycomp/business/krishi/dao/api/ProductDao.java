/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.dao.api;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycomp.business.krishi.entity.Product;

/**
 *
 * @author Amol
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

    @Query("from Product")
    public List<Product> getProductByJPQ();

    @Query(value = "select * from product", nativeQuery = true)
    public List<Product> getProductByNativeQuery();

    @Query("SELECT p FROM Product p WHERE p.productName = :productname")
    public List<Product> findProductByName(@Param("productname") String productName);

}
