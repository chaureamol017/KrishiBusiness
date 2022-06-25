package com.mycomp.krishi.service.adapter;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.ProductPrice;
import com.mycomp.krishi.service.model.ProductPriceModel;

public final class ProductPriceModelAdapter implements ModelAdapter<ProductPriceModel, ProductPrice> {
	public static final ProductPriceModelAdapter INSTANCE = new ProductPriceModelAdapter();

	private ProductPriceModelAdapter() {
	}

	@Override
	public ProductPrice toEntityMinimal(ProductPriceModel model) {
		if (null == model) {
			return null;
		}
		
		ProductPrice entity = new ProductPrice();
		entity.setProductId(model.getProductId());
		entity.setMinimumPrice(model.getMinimumPrice());
		entity.setMaximumPrice(model.getMaximumPrice());

		return entity;
	}

	@Override
	public ProductPrice toEntity(ProductPriceModel model) {
		if (null == model) {
			return null;
		}
		ProductPrice entity = toEntityMinimal(model);
		entity.setProductPriceId(model.getProductPriceId());

		return entity;
	}

	@Override
	public ProductPriceModel toModel(ProductPrice entity) {
		if (null == entity) {
			return null;
		}

		ProductPriceModel model = new ProductPriceModel();
		model.setProductPriceId(entity.getProductPriceId());
		model.setProductId(entity.getProductId());
		model.setMinimumPrice(entity.getMinimumPrice());
		model.setMaximumPrice(entity.getMaximumPrice());

		return model;
	}

}
