/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.api;

import com.mycomp.business.krishi.service.api.model.ProductModel;

/**
 *
 * @author Amol
 */
public interface ProductService {

    public ProductModel saveProduct(ProductModel model);

    public ProductModel updateProduct(ProductModel model);
    
    public ProductModel getProduct(Long productId);
    
    public boolean deleteProduct(Long productId);
}
