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

import com.mycomp.business.krishi.entity.ProductPrice;

/**
 *
 * @author Amol
 */
@Repository
public interface ProductPriceDao extends JpaRepository<ProductPrice, Long> {

    @Query(value = "SELECT pp FROM ProductPrice pp WHERE pp.productId = :productId")
    public List<ProductPrice> getProductPriceByProductId(@Param("productId") Long productId);

}
