package com.mycomp.business.krishi.service.api.adaptor;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.entity.Product;
//import com.mycomp.business.krishi.entity.type.ProductCategory;
import com.mycomp.business.krishi.service.api.model.ProductModel;

public class ProductModelAdaptor implements ModelAdaptor<ProductModel, Product> {
	public static final ProductModelAdaptor INSTANCE = new ProductModelAdaptor();

	public ProductModelAdaptor() {
	}

	public Product toEntityMinimal(ProductModel model) {
		if (null == model) {
			return null;
		}
		return createEntityWithouCopyingId(model);
	}

	public Product toEntity(ProductModel model) {
		if (null == model) {
			return null;
		}
		Product entity = createEntityWithouCopyingId(model);
		entity.setProductId(model.getProductId());

		return entity;
	}

	public ProductModel toServiceModel(Product entity) {
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

	private static Product createEntityWithouCopyingId(ProductModel model) {
		Product entity = new Product();

		entity.setProductName(model.getProductName());
		entity.setDescription(model.getDescription());
//		entity.setProductCategory(ProductCategory.valueOf(model.getProductCategory()));

		return entity;
	}

}
