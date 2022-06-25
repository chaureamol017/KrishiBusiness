package com.mycomp.krishi.service.adapter;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.Product;
import com.mycomp.krishi.service.model.ProductModel;

public class ProductModelAdapter implements ModelAdapter<ProductModel, Product> {
	public static final ProductModelAdapter INSTANCE = new ProductModelAdapter();

	public ProductModelAdapter() {
	}

	public Product toEntityMinimal(ProductModel model) {
		if (null == model) {
			return null;
		}
		
		Product entity = new Product();

		entity.setProductName(model.getProductName());
		entity.setDescription(model.getDescription());
//		entity.setProductCategory(ProductCategory.valueOf(model.getProductCategory()));

		return entity;
	}

	public Product toEntity(ProductModel model) {
		if (null == model) {
			return null;
		}

		Product entity = toEntityMinimal(model);
		entity.setProductId(model.getProductId());

		return entity;
	}

	public ProductModel toModel(Product entity) {
		if (null == entity) {
			return null;
		}
		ProductModel model = new ProductModel();

		model.setProductId(entity.getProductId());
		model.setProductName(entity.getProductName());
		model.setDescription(entity.getDescription());
//		model.setProductCategory(entity.getProductCategory().toString());

		return model;
	}

}
