package com.mycomp.business.krishi.service.api.adaptor;

import java.util.Date;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.entity.ProductPrice;
import com.mycomp.business.krishi.service.api.model.ProductPriceHistoryModel;
import com.mycomp.business.krishi.service.api.model.ProductPriceModel;

public final class ProductPriceModelAdaptor implements ModelAdaptor<ProductPriceModel, ProductPrice> {
	public static final ProductPriceModelAdaptor INSTANCE = new ProductPriceModelAdaptor();

	private ProductPriceModelAdaptor() {
	}

	@Override
	public ProductPrice toEntityMinimal(ProductPriceModel model) {
		if (null == model) {
			return null;
		}
		ProductPrice entity = createEntityWithouCopyingId(model);
		return entity;
	}

	@Override
	public ProductPrice toEntity(ProductPriceModel model) {
		if (null == model) {
			return null;
		}
		ProductPrice entity = createEntityWithouCopyingId(model);
		entity.setProductPriceId(model.getProductPriceId());

		return entity;
	}

	public static ProductPriceHistoryModel toHistoryServiceModel(ProductPriceModel model) {
		if (null == model) {
			return null;
		}
		ProductPriceHistoryModel historyModel = new ProductPriceHistoryModel();

		historyModel.setProductId(model.getProductId());
		historyModel.setMinimumPrice(model.getMinimumPrice());
		historyModel.setMaximumPrice(model.getMaximumPrice());
		historyModel.setPriceOn(new Date());

		return historyModel;
	}

	@Override
	public ProductPriceModel toServiceModel(ProductPrice entity) {
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

	private static ProductPrice createEntityWithouCopyingId(ProductPriceModel model) {
		ProductPrice entity = new ProductPrice();

		entity.setProductId(model.getProductId());
		entity.setMinimumPrice(model.getMinimumPrice());
		entity.setMaximumPrice(model.getMaximumPrice());

		return entity;
	}

}
