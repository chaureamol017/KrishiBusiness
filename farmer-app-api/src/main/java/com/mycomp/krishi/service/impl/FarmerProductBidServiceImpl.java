package com.mycomp.krishi.service.impl;

import com.mycomp.krishi.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.repository.FarmerProductBidRepository;
import com.mycomp.krishi.persistence.entity.FarmerProductBid;
import com.mycomp.krishi.service.adapter.FarmerProductBidModelAdapter;
import com.mycomp.krishi.service.api.FarmerProductBidService;
import com.mycomp.krishi.service.model.FarmerProductBidModel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerProductBidServiceImpl implements FarmerProductBidService {

	private final ModelAdapter<FarmerProductBidModel, FarmerProductBid> modelAdapter = FarmerProductBidModelAdapter.INSTANCE;
	private final FarmerProductBidRepository repository;

	@Autowired
	public FarmerProductBidServiceImpl(FarmerProductBidRepository repository) {
		this.repository = repository;
	}

	@Override
	public FarmerProductBidModel save(final FarmerProductBidModel model) {
		final FarmerProductBidModel existingBid =  getBid(model.getBuyerUserId(), model.getFarmerProductId());
		if (existingBid != null) {
			throw new RuntimeException("You already have bid for this product.");
		}
		final FarmerProductBid entityToSave = modelAdapter.toEntityMinimal(model);
		final FarmerProductBid savedEntity = repository.save(entityToSave);

		final FarmerProductBidModel result = modelAdapter.toModel(savedEntity);
		return result;
	}

	@Override
	public FarmerProductBidModel update(final FarmerProductBidModel model) {
		final FarmerProductBid entityToUpdate = modelAdapter.toEntity(model);
		final FarmerProductBid savedEntity = repository.saveAndFlush(entityToUpdate);

		final FarmerProductBidModel result = modelAdapter.toModel(savedEntity);
		return result;
	}

	@Override
	public FarmerProductBidModel getById(final Long productId) {
		final Optional<FarmerProductBid> optionalEntity = repository.findById(productId);

		if (optionalEntity.isPresent()) {
			return modelAdapter.toModel(optionalEntity.get());
		}
		return null;
	}

	@Override
	public FarmerProductBidModel getBid(Long buyerUserId, Long farmerProductId) {
		final List<FarmerProductBid> entities = repository.findByBuyerUserIdAndFarmerProductId(buyerUserId, farmerProductId);

		return entities.isEmpty() ? null : modelAdapter.toModel(entities.get(0));
	}

	@Override
		public Boolean deleteById(final Long id) {
		repository.deleteById(id);
		return true;
	}
}

