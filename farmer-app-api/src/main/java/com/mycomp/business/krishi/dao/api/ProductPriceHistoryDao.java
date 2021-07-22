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

import com.mycomp.business.krishi.entity.ProductPriceHistory;

/**
 *
 * @author Amol
 */
@Repository
public interface ProductPriceHistoryDao extends JpaRepository<ProductPriceHistory, Long> {

    @Query(value = "SELECT pph FROM ProductPriceHistory pph WHERE pph.productId = :productId")
    public List<ProductPriceHistory> getProductPriceHistoryByProductId(@Param("productId") Long productId);

}
