/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.impl;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.dao.api.ProductDao;
import com.mycomp.business.krishi.entity.Product;
import com.mycomp.business.krishi.service.api.ProductService;
import com.mycomp.business.krishi.service.api.adaptor.ProductModelAdaptor;
import com.mycomp.business.krishi.service.api.model.ProductModel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class ProductServiceImpl implements ProductService {
	private ModelAdaptor<ProductModel, Product> modelAdaptor = ProductModelAdaptor.INSTANCE;

	@Autowired private ProductDao productDao;

    @Override
    public ProductModel saveProduct(ProductModel model) {
    	final Product entityToSave = modelAdaptor.toEntityMinimal(model);
    	Product savedEntity = productDao.save(entityToSave);

		ProductModel result = modelAdaptor.toServiceModel(savedEntity);

		return result;
    }

    @Override
    public ProductModel updateProduct(ProductModel model) {
    	final Product entityToSave = modelAdaptor.toEntity(model);
    	Product savedEntity = productDao.saveAndFlush(entityToSave);

		ProductModel result = modelAdaptor.toServiceModel(savedEntity);

		return result;
    }

    @Override
    public ProductModel getProduct(Long productId) {
		Optional<Product> optionalEntity = productDao.findById(productId);

		if (optionalEntity.isPresent()) {
			return modelAdaptor.toServiceModel(optionalEntity.get());
		}
		return null;
    }

    @Override
    public List<ProductModel> getAllProducts() {
		List<Product> entities = productDao.findAll();

		return modelAdaptor.toServiceModel(entities);
    }

    @Override
    public boolean deleteProduct(Long productId) {
    	productDao.deleteById(productId);
    	return true;
    }
}
