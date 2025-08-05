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

	private ModelAdapter<FarmerProductBidModel, FarmerProductBid> modelAdapter = FarmerProductBidModelAdapter.INSTANCE;
	@Autowired private FarmerProductBidRepository repository;

	@Override
	public FarmerProductBidModel save(final FarmerProductBidModel model) {
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
	public List<FarmerProductBidModel> getAll() {
		final List<FarmerProductBid> entities = repository.findAll();

		return modelAdapter.toModel(entities);
	}
	@Override
		public Boolean deleteById(final Long id) {
		repository.deleteById(id);
		return true;
	}
}

