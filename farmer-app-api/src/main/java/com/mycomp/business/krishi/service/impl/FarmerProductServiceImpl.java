/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.impl;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.dao.api.FarmerProductDao;
import com.mycomp.business.krishi.entity.FarmerProduct;
import com.mycomp.business.krishi.service.api.FarmerProductService;
import com.mycomp.business.krishi.service.api.adaptor.FarmerProductModelAdaptor;
import com.mycomp.business.krishi.service.api.model.FarmerProductModel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class FarmerProductServiceImpl implements FarmerProductService {
	private ModelAdaptor<FarmerProductModel, FarmerProduct> modelAdaptor = FarmerProductModelAdaptor.INSTANCE;

	@Autowired
	private FarmerProductDao farmerProductDao;

	@Override
	public FarmerProductModel saveFarmerProduct(FarmerProductModel model) {

		final FarmerProduct entityToSave = modelAdaptor.toEntityMinimal(model);
		FarmerProduct savedEntity = farmerProductDao.save(entityToSave);

		FarmerProductModel result = modelAdaptor.toServiceModel(savedEntity);

		return result;
	}

	@Override
	public FarmerProductModel updateFarmerProduct(FarmerProductModel model) {
		final FarmerProduct entityToSave = modelAdaptor.toEntity(model);
		FarmerProduct savedEntity = farmerProductDao.saveAndFlush(entityToSave);

		FarmerProductModel result = modelAdaptor.toServiceModel(savedEntity);

		return result;
	}

	@Override
	public List<FarmerProductModel> getAllFarmerProducts() {
		List<FarmerProduct> entities = farmerProductDao.findAll();

		return modelAdaptor.toServiceModel(entities);
	}

	@Override
	public FarmerProductModel getFarmerProduct(Long farmerProductId) {
		Optional<FarmerProduct> optionalEntity = farmerProductDao.findById(farmerProductId);

		if (optionalEntity.isPresent()) {
			return modelAdaptor.toServiceModel(optionalEntity.get());
		}
		return null;
	}

	@Override
	public Boolean deleteFarmerProduct(Long farmerProductId) {
		farmerProductDao.deleteById(farmerProductId);
		return true;
	}

	@Override
	public List<FarmerProductModel> getFarmerProductsByProductId(Long productId) {
		List<FarmerProduct> entities = farmerProductDao.getFarmerProductsByProductId(productId);

		return modelAdaptor.toServiceModel(entities);
	}

	@Override
	public List<FarmerProductModel> getFarmerProductsByProductIdAndUserId(Long productId, Long userId) {
		List<FarmerProduct> entities = farmerProductDao.getFarmerProductsByProductIdAndUserId(productId, userId);

		return modelAdaptor.toServiceModel(entities);
	}

	@Override
	public List<FarmerProductModel> getFarmerProductsByUserId(Long userId) {
		List<FarmerProduct> entities = farmerProductDao.getFarmerProductsByUserId(userId);

		return modelAdaptor.toServiceModel(entities);
	}

	@Override
	public List<FarmerProductModel> getFarmerProductsByUserIdAndSoldStatus(Long userId, Boolean sold) {
		List<FarmerProduct> entities = farmerProductDao.getFarmerProductsByUserIdAndSold(userId,sold);

		return modelAdaptor.toServiceModel(entities);
	}

	@Override
	public List<FarmerProductModel> getFarmerProductsByProductIdUserIdAndSoldStatus(Long productId, Long userId,
			Boolean sold) {
		List<FarmerProduct> entities = farmerProductDao.getFarmerProductsByProductIdUserIdAndSold(productId, userId,
				sold);

		return modelAdaptor.toServiceModel(entities);
	}

}
