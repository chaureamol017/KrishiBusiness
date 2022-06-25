/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.service.impl;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.dataprovider.repository.ProductPriceRepository;
import com.mycomp.krishi.persistence.entity.ProductPrice;
import com.mycomp.krishi.service.adapter.ProductPriceModelAdapter;
import com.mycomp.krishi.service.adapter.ProductPriceToProductPriceHistoryModelAdapter;
import com.mycomp.krishi.service.api.ProductPriceHistoryService;
import com.mycomp.krishi.service.api.ProductPriceService;
import com.mycomp.krishi.service.model.ProductPriceHistoryModel;
import com.mycomp.krishi.service.model.ProductPriceModel;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class ProductPriceServiceImpl implements ProductPriceService {
	private ModelAdapter<ProductPriceModel, ProductPrice> modelAdapter = ProductPriceModelAdapter.INSTANCE;
	private ProductPriceToProductPriceHistoryModelAdapter historyAdapter = ProductPriceToProductPriceHistoryModelAdapter.INSTANCE;

	@Autowired private ProductPriceRepository productPriceRepository;
	@Autowired private ProductPriceHistoryService productPriceHistoryService;

    @Override
    public ProductPriceModel saveProductPrice(ProductPriceModel model) {

    	final ProductPrice entityToSave = modelAdapter.toEntityMinimal(model);
    	ProductPrice savedEntity = productPriceRepository.save(entityToSave);
    	
    	final ProductPriceHistoryModel historyModel = historyAdapter.apply(model);
    	productPriceHistoryService.saveProductPriceHistory(historyModel);

		return modelAdapter.toModel(savedEntity);
    }

    @Override
    public ProductPriceModel updateProductPrice(ProductPriceModel model) {
    	final ProductPrice entityToSave = modelAdapter.toEntity(model);
    	ProductPrice savedEntity = productPriceRepository.saveAndFlush(entityToSave);

		return modelAdapter.toModel(savedEntity);
    }

    @Override
    public ProductPriceModel getProductPrice(Long productPriceId) {
		Optional<ProductPrice> optionalEntity = productPriceRepository.findById(productPriceId);

		if (optionalEntity.isPresent()) {
			return modelAdapter.toModel(optionalEntity.get());
		}
		return null;
    }
    
    @Override
    public boolean deleteProductPrice(Long productPriceId) {
    	productPriceRepository.deleteById(productPriceId);
    	return true;
    }
}
