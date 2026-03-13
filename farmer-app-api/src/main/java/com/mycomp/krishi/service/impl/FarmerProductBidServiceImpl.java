package com.mycomp.krishi.service.impl;

import com.mycomp.krishi.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.FarmerProduct;
import com.mycomp.krishi.persistence.repository.FarmerProductBidRepository;
import com.mycomp.krishi.persistence.entity.FarmerProductBid;
import com.mycomp.krishi.service.adapter.FarmerProductBidModelAdapter;
import com.mycomp.krishi.service.api.FarmerProductBidService;
import com.mycomp.krishi.service.api.FarmerProductService;
import com.mycomp.krishi.service.model.FarmerProductBidModel;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FarmerProductBidServiceImpl implements FarmerProductBidService {

	private final ModelAdapter<FarmerProductBidModel, FarmerProductBid> modelAdapter = FarmerProductBidModelAdapter.INSTANCE;
	private final FarmerProductBidRepository repository;
	private final FarmerProductService farmerProductService;

	@Autowired
	public FarmerProductBidServiceImpl(FarmerProductBidRepository repository, FarmerProductService farmerProductService) {
		this.repository = repository;
		this.farmerProductService = farmerProductService;
	}

	@Override
	public FarmerProductBidModel save(final FarmerProductBidModel model) {
		final FarmerProductBidModel existingBid =  getBidForBuyerAndProduct(model.getBuyerUserId(), model.getFarmerProductId());
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
	public int acceptBid(Long productBidId) {
		final FarmerProductBid farmerProductBid = repository.findById(productBidId)
				.orElseThrow(() -> new EntityNotFoundException("FarmerProductBid not found"));

		farmerProductBid.setAccepted(true);
		farmerProductBid.setAcceptedOn(new Date());

		farmerProductService.markSold(farmerProductBid.getFarmerProductId());

		return 1;
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
	public FarmerProductBidModel getBidForBuyerAndProduct(Long buyerUserId, Long farmerProductId) {
		final List<FarmerProductBid> entities = repository.findByBuyerUserIdAndFarmerProductId(buyerUserId, farmerProductId);

		return entities.isEmpty() ? null : modelAdapter.toModel(entities.get(0));
	}

	@Override
	public List<FarmerProductBidModel> getBidForProduct(Long farmerProductId) {
		final List<FarmerProductBid> entities = repository.findByFarmerProductId(farmerProductId);

		return modelAdapter.toModel(entities);
	}

	@Override
		public Boolean deleteById(final Long id) {
		repository.deleteById(id);
		return true;
	}
}

