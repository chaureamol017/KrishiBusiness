package com.mycomp.krishi.service.adapter;

import com.mycomp.krishi.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.Product;
import com.mycomp.krishi.service.model.ProductModel;

public class ProductModelAdapter implements ModelAdapter<ProductModel, Product> {

public static final ProductModelAdapter INSTANCE = new ProductModelAdapter();

	private ProductModelAdapter() {
	}
	public Product toEntityMinimal(final ProductModel model) {
		if (null == model) {
			return null;
		}

		final Product entity = new Product();

		entity.setProductId(model.getProductId());
		entity.setName(model.getName());
		entity.setDescription(model.getDescription());
		entity.setCategory(model.getCategory());

		return entity;
	}

	public Product toEntity(final ProductModel model) {
		if (null == model) {
			return null;
		}

        return toEntityMinimal(model);
	}

	public ProductModel toModel(final Product entity) {
		if (null == entity) {
			return null;
		}

		final ProductModel model = new ProductModel();

		model.setProductId(entity.getProductId());
		model.setName(entity.getName());
		model.setDescription(entity.getDescription());
		model.setCategory(entity.getCategory());

		return model;
	}
}

