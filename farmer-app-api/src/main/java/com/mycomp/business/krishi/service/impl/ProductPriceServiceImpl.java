/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.impl;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.dao.api.ProductPriceDao;
import com.mycomp.business.krishi.entity.ProductPrice;
import com.mycomp.business.krishi.service.api.ProductPriceHistoryService;
import com.mycomp.business.krishi.service.api.ProductPriceService;
import com.mycomp.business.krishi.service.api.adaptor.ProductPriceModelAdaptor;
import com.mycomp.business.krishi.service.api.model.ProductPriceHistoryModel;
import com.mycomp.business.krishi.service.api.model.ProductPriceModel;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class ProductPriceServiceImpl implements ProductPriceService {
	private ModelAdaptor<ProductPriceModel, ProductPrice> modelAdaptor = ProductPriceModelAdaptor.INSTANCE;

	@Autowired private ProductPriceDao productPriceDao;
	@Autowired private ProductPriceHistoryService productPriceHistoryService;

    @Override
    public ProductPriceModel saveProductPrice(ProductPriceModel model) {

    	final ProductPrice entityToSave = modelAdaptor.toEntityMinimal(model);
    	ProductPrice savedEntity = productPriceDao.save(entityToSave);
    	
    	final ProductPriceHistoryModel historyModel = ProductPriceModelAdaptor.toHistoryServiceModel(model);
    	productPriceHistoryService.saveProductPriceHistory(historyModel);

		return modelAdaptor.toServiceModel(savedEntity);
    }

    @Override
    public ProductPriceModel updateProductPrice(ProductPriceModel model) {
    	final ProductPrice entityToSave = modelAdaptor.toEntity(model);
    	ProductPrice savedEntity = productPriceDao.saveAndFlush(entityToSave);

		return modelAdaptor.toServiceModel(savedEntity);
    }

    @Override
    public ProductPriceModel getProductPrice(Long productPriceId) {
		Optional<ProductPrice> optionalEntity = productPriceDao.findById(productPriceId);

		if (optionalEntity.isPresent()) {
			return modelAdaptor.toServiceModel(optionalEntity.get());
		}
		return null;
    }
    
    @Override
    public boolean deleteProductPrice(Long productPriceId) {
    	productPriceDao.deleteById(productPriceId);
    	return true;
    }
}
