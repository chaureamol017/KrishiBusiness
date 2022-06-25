/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.service.impl;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.dataprovider.repository.FarmerProductBidRepository;
import com.mycomp.krishi.persistence.entity.FarmerProductBid;
import com.mycomp.krishi.service.adapter.FarmerProductBidHelper;
import com.mycomp.krishi.service.adapter.FarmerProductBidModelAdapter;
import com.mycomp.krishi.service.api.FarmerProductBidService;
import com.mycomp.krishi.service.model.FarmerProductBidModel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class FarmerProductBidServiceImpl implements FarmerProductBidService {
	private ModelAdapter<FarmerProductBidModel, FarmerProductBid> modelAdapter = FarmerProductBidModelAdapter.INSTANCE;
	private FarmerProductBidHelper helper = FarmerProductBidHelper.INSTANCE;

	@Autowired
	private FarmerProductBidRepository farmerProductBidRepository;

	@Override
	public FarmerProductBidModel saveFarmerProductBid(FarmerProductBidModel model) {

		final FarmerProductBid entityToSave = modelAdapter.toEntityMinimal(model);
		FarmerProductBid savedEntity = farmerProductBidRepository.save(entityToSave);

		return modelAdapter.toModel(savedEntity);
	}

	@Override
	public FarmerProductBidModel updateFarmerProductBid(FarmerProductBidModel model) {

		final FarmerProductBid entityToSave = modelAdapter.toEntityMinimal(model);
		FarmerProductBid savedEntity = farmerProductBidRepository.save(entityToSave);

		return modelAdapter.toModel(savedEntity);
	}

	@Override
	public List<FarmerProductBidModel> getAllFarmerProductBids() {
		List<FarmerProductBid> savedEntity = farmerProductBidRepository.findAll();

		return modelAdapter.toModel(savedEntity);
	}

	@Override
	public FarmerProductBidModel getFarmerProductBid(Long farmerProductBidId) {
		Optional<FarmerProductBid> optionalEntity = farmerProductBidRepository.findById(farmerProductBidId);

		if (optionalEntity.isPresent()) {
			return modelAdapter.toModel(optionalEntity.get());
		}
		return null;
	}

	@Override
	public Boolean deleteFarmerProductBid(Long farmerProductBidId) {
		farmerProductBidRepository.deleteById(farmerProductBidId);
		return true;
	}

	@Override
	public FarmerProductBidModel acceptBid(Long farmerProductBidId) {
		Optional<FarmerProductBid> optionalEntity = farmerProductBidRepository.findById(farmerProductBidId);

		if (optionalEntity.isPresent()) {
			FarmerProductBid entity = optionalEntity.get();
			helper.acceptBid(entity);

			farmerProductBidRepository.save(entity);

			return modelAdapter.toModel(entity);
		}
		return null;
	}

	@Override
	public List<FarmerProductBidModel> getFarmerProductBidsByProductIdAndBuyerUserId(Long productId, Long buyerUserId) {
		List<FarmerProductBid> savedEntity = farmerProductBidRepository .findByProductIdAndBuyerUserId(productId, buyerUserId);

		return modelAdapter.toModel(savedEntity);
	}

	@Override
	public List<FarmerProductBidModel> getFarmerProductBidsByFarmerProductId(Long farmerProductId) {
		List<FarmerProductBid> savedEntity = farmerProductBidRepository.findByFarmerProductId(farmerProductId);

		return modelAdapter.toModel(savedEntity);
	}

}
