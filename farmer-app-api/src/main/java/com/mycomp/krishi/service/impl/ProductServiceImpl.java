package com.mycomp.krishi.service.impl;

import com.mycomp.krishi.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.repository.ProductRepository;
import com.mycomp.krishi.persistence.entity.Product;
import com.mycomp.krishi.service.adapter.ProductModelAdapter;
import com.mycomp.krishi.service.api.ProductService;
import com.mycomp.krishi.service.model.ProductModel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	private ModelAdapter<ProductModel, Product> modelAdapter = ProductModelAdapter.INSTANCE;
	@Autowired private ProductRepository repository;

	@Override
	public ProductModel save(final ProductModel model) {
		final Product entityToSave = modelAdapter.toEntityMinimal(model);
		final Product savedEntity = repository.save(entityToSave);

		final ProductModel result = modelAdapter.toModel(savedEntity);

		return result;
	}
	@Override
	public ProductModel update(final ProductModel model) {
		final Product entityToUpdate = modelAdapter.toEntity(model);
		final Product savedEntity = repository.saveAndFlush(entityToUpdate);

		final ProductModel result = modelAdapter.toModel(savedEntity);

		return result;
	}
	@Override
	public ProductModel getById(final Long productId) {
		final Optional<Product> optionalEntity = repository.findById(productId);

		if (optionalEntity.isPresent()) {
			return modelAdapter.toModel(optionalEntity.get());
		}
		return null;
	}
	@Override
	public List<ProductModel> getAll() {
		final List<Product> entities = repository.findAll();

		return modelAdapter.toModel(entities);
	}
	@Override
		public Boolean deleteById(final Long id) {
		repository.deleteById(id);
		return true;
	}
}

