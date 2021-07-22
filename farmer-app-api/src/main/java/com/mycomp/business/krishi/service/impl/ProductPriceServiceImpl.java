/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.impl;

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

	@Autowired private ProductPriceDao productPriceDao;
	@Autowired private ProductPriceHistoryService productPriceHistoryService;

    @Override
    public ProductPriceModel saveProductPrice(ProductPriceModel model) {

    	final ProductPrice entityToSave = ProductPriceModelAdaptor.toEntityMinimal(model);
    	ProductPrice savedEntity = productPriceDao.save(entityToSave);
    	
    	final ProductPriceHistoryModel historyModel = ProductPriceModelAdaptor.toHistoryServiceModel(model);
    	productPriceHistoryService.saveProductPriceHistory(historyModel);

		ProductPriceModel result = ProductPriceModelAdaptor.toServiceModel(savedEntity);

		return result;
    }

    @Override
    public ProductPriceModel updateProductPrice(ProductPriceModel model) {
    	final ProductPrice entityToSave = ProductPriceModelAdaptor.toEntity(model);
    	ProductPrice savedEntity = productPriceDao.saveAndFlush(entityToSave);

		ProductPriceModel result = ProductPriceModelAdaptor.toServiceModel(savedEntity);

		return result;
    }

    @Override
    public ProductPriceModel getProductPrice(Long productPriceId) {
		Optional<ProductPrice> optionalEntity = productPriceDao.findById(productPriceId);

		if (optionalEntity.isPresent()) {
			return ProductPriceModelAdaptor.toServiceModel(optionalEntity.get());
		}
		return null;
    }
    
    @Override
    public boolean deleteProductPrice(Long productPriceId) {
    	productPriceDao.deleteById(productPriceId);
    	return true;
    }
}
