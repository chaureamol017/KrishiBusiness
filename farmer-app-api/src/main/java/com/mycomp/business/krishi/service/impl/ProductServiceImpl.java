/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.impl;

import com.mycomp.business.krishi.dao.api.ProductDao;
import com.mycomp.business.krishi.entity.Product;
import com.mycomp.business.krishi.service.api.ProductService;
import com.mycomp.business.krishi.service.api.adaptor.ProductModelAdaptor;
import com.mycomp.business.krishi.service.api.model.ProductModel;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired private ProductDao productDao;

    @Override
    public ProductModel saveProduct(ProductModel model) {

    	final Product entityToSave = ProductModelAdaptor.toEntityMinimal(model);
    	Product savedEntity = productDao.save(entityToSave);

		ProductModel result = ProductModelAdaptor.toServiceModel(savedEntity);

		return result;
    }

    @Override
    public ProductModel updateProduct(ProductModel model) {
    	final Product entityToSave = ProductModelAdaptor.toEntity(model);
    	Product savedEntity = productDao.saveAndFlush(entityToSave);

		ProductModel result = ProductModelAdaptor.toServiceModel(savedEntity);

		return result;
    }

    @Override
    public ProductModel getProduct(Long productId) {
		Optional<Product> optionalEntity = productDao.findById(productId);

		if (optionalEntity.isPresent()) {
			return ProductModelAdaptor.toServiceModel(optionalEntity.get());
		}
		return null;
    }
    
    @Override
    public boolean deleteProduct(Long productId) {
    	productDao.deleteById(productId);
    	return true;
    }
}
