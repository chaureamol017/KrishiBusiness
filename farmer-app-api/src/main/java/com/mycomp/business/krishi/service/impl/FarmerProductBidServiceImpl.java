/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.impl;

import com.mycomp.business.krishi.dao.api.FarmerProductBidDao;
import com.mycomp.business.krishi.entity.FarmerProductBid;
import com.mycomp.business.krishi.service.api.FarmerProductBidService;
import com.mycomp.business.krishi.service.api.adaptor.FarmerProductBidModelAdaptor;
import com.mycomp.business.krishi.service.api.model.FarmerProductBidModel;

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

	@Autowired
	private FarmerProductBidDao farmerProductBidDao;

	@Override
	public FarmerProductBidModel saveFarmerProductBid(FarmerProductBidModel model) {

		final FarmerProductBid entityToSave = FarmerProductBidModelAdaptor.toEntityMinimal(model);
		FarmerProductBid savedEntity = farmerProductBidDao.save(entityToSave);

		FarmerProductBidModel result = FarmerProductBidModelAdaptor.toServiceModel(savedEntity);

		return result;
	}

	@Override
	public FarmerProductBidModel updateFarmerProductBid(FarmerProductBidModel model) {

		final FarmerProductBid entityToSave = FarmerProductBidModelAdaptor.toEntityMinimal(model);
		FarmerProductBid savedEntity = farmerProductBidDao.save(entityToSave);

		FarmerProductBidModel result = FarmerProductBidModelAdaptor.toServiceModel(savedEntity);

		return result;
	}

	@Override
	public List<FarmerProductBidModel> getAllFarmerProductBids() {
		List<FarmerProductBid> savedEntity = farmerProductBidDao.findAll();

		List<FarmerProductBidModel> result = FarmerProductBidModelAdaptor.toServiceModel(savedEntity);
		return result;
	}

	@Override
	public FarmerProductBidModel getFarmerProductBid(Long farmerProductBidId) {
		Optional<FarmerProductBid> optionalEntity = farmerProductBidDao.findById(farmerProductBidId);

		if (optionalEntity.isPresent()) {
			return FarmerProductBidModelAdaptor.toServiceModel(optionalEntity.get());
		}
		return null;
	}

	@Override
	public Boolean deleteFarmerProductBid(Long farmerProductBidId) {
		farmerProductBidDao.deleteById(farmerProductBidId);
		return true;
	}

	@Override
	public FarmerProductBidModel acceptBid(Long farmerProductBidId) {
		Optional<FarmerProductBid> optionalEntity = farmerProductBidDao.findById(farmerProductBidId);

		if (optionalEntity.isPresent()) {
			FarmerProductBid entity = optionalEntity.get();
			FarmerProductBidModelAdaptor.acceptBid(entity);
			farmerProductBidDao.save(entity);

			return FarmerProductBidModelAdaptor.toServiceModel(entity);
		}
		return null;
	}

	@Override
	public List<FarmerProductBidModel> getFarmerProductBidsByProductIdAndBuyerUserId(Long productId, Long buyerUserId) {
		List<FarmerProductBid> savedEntity = farmerProductBidDao
				.getFarmerProductBidsByProductIdAndBuyerUserId(productId, buyerUserId);

		List<FarmerProductBidModel> result = FarmerProductBidModelAdaptor.toServiceModel(savedEntity);
		return result;
	}

	@Override
	public List<FarmerProductBidModel> getFarmerProductBidsByFarmerProductId(Long farmerProductId) {
		List<FarmerProductBid> savedEntity = farmerProductBidDao.getFarmerProductBidsByFarmerProductId(farmerProductId);

		List<FarmerProductBidModel> result = FarmerProductBidModelAdaptor.toServiceModel(savedEntity);
		return result;
	}

}
