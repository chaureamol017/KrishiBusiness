package com.mycomp.krishi.service.impl;

import com.mycomp.krishi.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.repository.FarmerProductRepository;
import com.mycomp.krishi.persistence.entity.FarmerProduct;
import com.mycomp.krishi.service.adapter.FarmerProductModelAdapter;
import com.mycomp.krishi.service.api.FarmerProductService;
import com.mycomp.krishi.service.model.FarmerProductModel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerProductServiceImpl implements FarmerProductService {

	private ModelAdapter<FarmerProductModel, FarmerProduct> modelAdapter = FarmerProductModelAdapter.INSTANCE;
	@Autowired private FarmerProductRepository repository;

	@Override
	public FarmerProductModel save(final FarmerProductModel model) {
		final FarmerProduct entityToSave = modelAdapter.toEntityMinimal(model);
		final FarmerProduct savedEntity = repository.save(entityToSave);

		final FarmerProductModel result = modelAdapter.toModel(savedEntity);

		return result;
	}
	@Override
	public FarmerProductModel update(final FarmerProductModel model) {
		final FarmerProduct entityToUpdate = modelAdapter.toEntity(model);
		final FarmerProduct savedEntity = repository.saveAndFlush(entityToUpdate);

		final FarmerProductModel result = modelAdapter.toModel(savedEntity);

		return result;
	}
	@Override
	public FarmerProductModel getById(final Long productId) {
		final Optional<FarmerProduct> optionalEntity = repository.findById(productId);

		if (optionalEntity.isPresent()) {
			return modelAdapter.toModel(optionalEntity.get());
		}
		return null;
	}
	@Override
	public List<FarmerProductModel> getAll() {
		final List<FarmerProduct> entities = repository.findAll();

		return modelAdapter.toModel(entities);
	}
	@Override
		public Boolean deleteById(final Long id) {
		repository.deleteById(id);
		return true;
	}
}

