/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.service.impl;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.dataprovider.repository.FarmerProductRepository;
import com.mycomp.krishi.persistence.entity.FarmerProduct;
import com.mycomp.krishi.service.adapter.FarmerProductModelAdapter;
import com.mycomp.krishi.service.api.FarmerProductService;
import com.mycomp.krishi.service.model.FarmerProductModel;

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
	private ModelAdapter<FarmerProductModel, FarmerProduct> modelAdapter = FarmerProductModelAdapter.INSTANCE;

	@Autowired
	private FarmerProductRepository farmerProductRepository;

	@Override
	public FarmerProductModel saveFarmerProduct(FarmerProductModel model) {

		final FarmerProduct entityToSave = modelAdapter.toEntityMinimal(model);
		FarmerProduct savedEntity = farmerProductRepository.save(entityToSave);

		FarmerProductModel result = modelAdapter.toModel(savedEntity);

		return result;
	}

	@Override
	public FarmerProductModel updateFarmerProduct(FarmerProductModel model) {
		final FarmerProduct entityToSave = modelAdapter.toEntity(model);
		FarmerProduct savedEntity = farmerProductRepository.saveAndFlush(entityToSave);

		FarmerProductModel result = modelAdapter.toModel(savedEntity);

		return result;
	}

	@Override
	public List<FarmerProductModel> getAllFarmerProducts() {
		List<FarmerProduct> entities = farmerProductRepository.findAll();

		return modelAdapter.toModel(entities);
	}

	@Override
	public FarmerProductModel getFarmerProduct(Long farmerProductId) {
		Optional<FarmerProduct> optionalEntity = farmerProductRepository.findById(farmerProductId);

		if (optionalEntity.isPresent()) {
			return modelAdapter.toModel(optionalEntity.get());
		}
		return null;
	}

	@Override
	public Boolean deleteFarmerProduct(Long farmerProductId) {
		farmerProductRepository.deleteById(farmerProductId);
		return true;
	}

	@Override
	public List<FarmerProductModel> getFarmerProductsByProductId(Long productId) {
		List<FarmerProduct> entities = farmerProductRepository.findByProductId(productId);

		return modelAdapter.toModel(entities);
	}

	@Override
	public List<FarmerProductModel> getFarmerProductsByProductIdAndUserId(Long productId, Long userId) {
		List<FarmerProduct> entities = farmerProductRepository.findByProductIdAndUserId(productId, userId);

		return modelAdapter.toModel(entities);
	}

	@Override
	public List<FarmerProductModel> getFarmerProductsByUserId(Long userId) {
		List<FarmerProduct> entities = farmerProductRepository.findByUserId(userId);

		return modelAdapter.toModel(entities);
	}

	@Override
	public List<FarmerProductModel> getFarmerProductsByUserIdAndSoldStatus(Long userId, Boolean sold) {
		List<FarmerProduct> entities = farmerProductRepository.findByUserIdAndSold(userId,sold);

		return modelAdapter.toModel(entities);
	}

	@Override
	public List<FarmerProductModel> getFarmerProductsByProductIdUserIdAndSoldStatus(Long productId, Long userId, Boolean sold) {
		List<FarmerProduct> entities = farmerProductRepository.findByProductIdAndUserIdAndSold(productId, userId, sold);

		return modelAdapter.toModel(entities);
	}

}
