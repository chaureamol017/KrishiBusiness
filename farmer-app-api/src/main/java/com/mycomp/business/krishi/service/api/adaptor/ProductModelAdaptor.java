package com.mycomp.business.krishi.service.api.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.entity.Product;
//import com.mycomp.business.krishi.entity.type.ProductCategory;
import com.mycomp.business.krishi.service.api.model.ProductModel;

public class ProductModelAdaptor {

	public static List<Product> toEntityMinimal(List<ProductModel> models) {
		if (null == models) {
			return null;
		}
		List<Product> entities = models.stream().map(model -> createEntityWithouCopyingId(model))
				.collect(Collectors.toList());
		return entities;
	}

	public static Product toEntityMinimal(ProductModel model) {
		if (null == model) {
			return null;
		}
		Product entity = createEntityWithouCopyingId(model);
		return entity;
	}

	public static Product toEntity(ProductModel model) {
		if (null == model) {
			return null;
		}
		Product entity = createEntityWithouCopyingId(model);
		entity.setProductId(model.getProductId());

		return entity;
	}

	public static List<ProductModel> toServiceModel(List<Product> entities) {
		List<ProductModel> models = entities.stream().map(entity -> createServiceModel(entity))
				.collect(Collectors.toList());

		return models;
	}

	public static ProductModel toServiceModel(Product entity) {
		if (null == entity) {
			return null;
		}
		ProductModel model = createServiceModel(entity);
		return model;
	}

	private static Product createEntityWithouCopyingId(ProductModel model) {
		Product entity = new Product();

		entity.setProductName(model.getProductName());
		entity.setDescription(model.getDescription());
//		entity.setProductCategory(ProductCategory.valueOf(model.getProductCategory()));

		return entity;
	}

	private static ProductModel createServiceModel(Product entity) {
		ProductModel model = new ProductModel();

		model.setProductId(entity.getProductId());
		model.setProductName(entity.getProductName());
		model.setDescription(entity.getDescription());
//		model.setProductCategory(entity.getProductCategory().toString());

		return model;
	}

}
