package com.mycomp.krishi.service.impl;

import com.mycomp.krishi.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.repository.FarmerProductRepository;
import com.mycomp.krishi.persistence.entity.FarmerProduct;
import com.mycomp.krishi.persistence.specification.FarmerProductSpecification;
import com.mycomp.krishi.service.adapter.FarmerProductModelAdapter;
import com.mycomp.krishi.service.api.FarmerProductService;
import com.mycomp.krishi.service.model.FarmerProductModel;

import java.util.Date;
import java.util.List;
import java.util.Map;
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
	public int markSold(final Long farmerProductId) {
		final int updateCount = repository.markSold(farmerProductId, true, new Date());

		return updateCount;
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
	public List<FarmerProductModel> getBySeller(Long userId) {
		final List<FarmerProduct> entities = repository.findByUserId(userId);

		return modelAdapter.toModel(entities);
	}

	@Override
	public List<FarmerProductModel> getForSeller(Long userId) {
		final List<FarmerProduct> entities = repository.findAvailableForBuy(userId);

		return modelAdapter.toModel(entities);
	}

	@Override
	public List<FarmerProductModel> searchProducts(Long userId, Map<String, String> filters) {
		final List<FarmerProduct> entities = repository.findAll(
				FarmerProductSpecification.withFilters(userId, filters));

		return modelAdapter.toModel(entities);
	}

	@Override
		public Boolean deleteById(final Long id) {
		repository.deleteById(id);
		return true;
	}
}

