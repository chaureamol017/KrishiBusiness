/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.api;

import java.util.List;

import com.mycomp.business.krishi.service.api.model.ProductPriceHistoryModel;

/**
 *
 * @author Amol
 */
public interface ProductPriceHistoryService {

    public ProductPriceHistoryModel saveProductPriceHistory(ProductPriceHistoryModel model);

    public ProductPriceHistoryModel getProductPriceHistory(Long productPriceHistoryId);
    
    public boolean deleteProductPriceHistory(Long productPriceHistoryId);
    
    List<ProductPriceHistoryModel> getProductPriceHistoryByProductId(Long productId);
}
