/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.impl;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.dao.api.ProductPriceHistoryDao;
import com.mycomp.business.krishi.entity.ProductPriceHistory;
import com.mycomp.business.krishi.service.api.ProductPriceHistoryService;
import com.mycomp.business.krishi.service.api.adaptor.ProductPriceHistoryModelAdaptor;
import com.mycomp.business.krishi.service.api.model.ProductPriceHistoryModel;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class ProductPriceHistoryServiceImpl implements ProductPriceHistoryService {
	private ModelAdaptor<ProductPriceHistoryModel, ProductPriceHistory> modelAdaptor = ProductPriceHistoryModelAdaptor.INSTANCE;

	@Autowired private ProductPriceHistoryDao productPriceHistoryDao;

    @Override
    public ProductPriceHistoryModel saveProductPriceHistory(ProductPriceHistoryModel model) {

    	final ProductPriceHistory entityToSave = modelAdaptor.toEntityMinimal(model);
    	ProductPriceHistory savedEntity = productPriceHistoryDao.save(entityToSave);

		ProductPriceHistoryModel result = modelAdaptor.toServiceModel(savedEntity);

		return result;
    }

    @Override
    public ProductPriceHistoryModel getProductPriceHistory(Long productPriceHistoryId) {
		Optional<ProductPriceHistory> optionalEntity = productPriceHistoryDao.findById(productPriceHistoryId);

		if (optionalEntity.isPresent()) {
			return modelAdaptor.toServiceModel(optionalEntity.get());
		}
		return null;
    }

    @Override
    public boolean deleteProductPriceHistory(Long productPriceHistoryId) {
    	productPriceHistoryDao.deleteById(productPriceHistoryId);
    	return true;
    }

    @Override
    public List<ProductPriceHistoryModel> getProductPriceHistoryByProductId(Long productId) {
    	List<ProductPriceHistory> entities = productPriceHistoryDao.getProductPriceHistoryByProductId(productId);

			return modelAdaptor.toServiceModel(entities);
    }

}
