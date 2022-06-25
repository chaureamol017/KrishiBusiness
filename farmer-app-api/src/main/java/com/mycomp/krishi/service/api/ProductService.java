/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.service.api;

import java.util.List;

import com.mycomp.krishi.service.model.ProductModel;

/**
 *
 * @author Amol
 */
public interface ProductService {

    public ProductModel saveProduct(ProductModel model);

    public ProductModel updateProduct(ProductModel model);

    public ProductModel getProduct(Long productId);

    public List<ProductModel> getAllProducts();
    
    public boolean deleteProduct(Long productId);
}
