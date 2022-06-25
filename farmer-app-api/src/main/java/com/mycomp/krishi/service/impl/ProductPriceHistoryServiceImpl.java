/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.service.impl;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.dataprovider.repository.ProductPriceHistoryRepository;
import com.mycomp.krishi.persistence.entity.ProductPriceHistory;
import com.mycomp.krishi.service.adapter.ProductPriceHistoryModelAdapter;
import com.mycomp.krishi.service.api.ProductPriceHistoryService;
import com.mycomp.krishi.service.model.ProductPriceHistoryModel;

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
	private ModelAdapter<ProductPriceHistoryModel, ProductPriceHistory> modelAdapter = ProductPriceHistoryModelAdapter.INSTANCE;

	@Autowired private ProductPriceHistoryRepository productPriceHistoryRepository;

    @Override
    public ProductPriceHistoryModel saveProductPriceHistory(ProductPriceHistoryModel model) {

    	final ProductPriceHistory entityToSave = modelAdapter.toEntityMinimal(model);
    	ProductPriceHistory savedEntity = productPriceHistoryRepository.save(entityToSave);

		ProductPriceHistoryModel result = modelAdapter.toModel(savedEntity);

		return result;
    }

    @Override
    public ProductPriceHistoryModel getProductPriceHistory(Long productPriceHistoryId) {
		Optional<ProductPriceHistory> optionalEntity = productPriceHistoryRepository.findById(productPriceHistoryId);

		if (optionalEntity.isPresent()) {
			return modelAdapter.toModel(optionalEntity.get());
		}
		return null;
    }

    @Override
    public boolean deleteProductPriceHistory(Long productPriceHistoryId) {
    	productPriceHistoryRepository.deleteById(productPriceHistoryId);
    	return true;
    }

    @Override
    public List<ProductPriceHistoryModel> getProductPriceHistoryByProductId(Long productId) {
    	List<ProductPriceHistory> entities = productPriceHistoryRepository.findByProductId(productId);

			return modelAdapter.toModel(entities);
    }

}
