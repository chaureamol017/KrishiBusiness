/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.service.impl;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.dataprovider.repository.ProductRepository;
import com.mycomp.krishi.persistence.entity.Product;
import com.mycomp.krishi.service.adapter.ProductModelAdapter;
import com.mycomp.krishi.service.api.ProductService;
import com.mycomp.krishi.service.model.ProductModel;

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
	private ModelAdapter<ProductModel, Product> modelAdapter = ProductModelAdapter.INSTANCE;

	@Autowired private ProductRepository productRepository;

    @Override
    public ProductModel saveProduct(ProductModel model) {
    	final Product entityToSave = modelAdapter.toEntityMinimal(model);
    	Product savedEntity = productRepository.save(entityToSave);

		ProductModel result = modelAdapter.toModel(savedEntity);

		return result;
    }

    @Override
    public ProductModel updateProduct(ProductModel model) {
    	final Product entityToSave = modelAdapter.toEntity(model);
    	Product savedEntity = productRepository.saveAndFlush(entityToSave);

		ProductModel result = modelAdapter.toModel(savedEntity);

		return result;
    }

    @Override
    public ProductModel getProduct(Long productId) {
		Optional<Product> optionalEntity = productRepository.findById(productId);

		if (optionalEntity.isPresent()) {
			return modelAdapter.toModel(optionalEntity.get());
		}
		return null;
    }

    @Override
    public List<ProductModel> getAllProducts() {
		List<Product> entities = productRepository.findAll();

		return modelAdapter.toModel(entities);
    }

    @Override
    public boolean deleteProduct(Long productId) {
    	productRepository.deleteById(productId);
    	return true;
    }
}
