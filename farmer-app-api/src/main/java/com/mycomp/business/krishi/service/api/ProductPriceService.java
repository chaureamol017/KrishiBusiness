/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.api;

import com.mycomp.business.krishi.service.api.model.ProductPriceModel;

/**
 *
 * @author Amol
 */
public interface ProductPriceService {

    public ProductPriceModel saveProductPrice(ProductPriceModel model);

    public ProductPriceModel updateProductPrice(ProductPriceModel model);
    
    public ProductPriceModel getProductPrice(Long productPriceId);
    
    public boolean deleteProductPrice(Long productPriceId);
}
