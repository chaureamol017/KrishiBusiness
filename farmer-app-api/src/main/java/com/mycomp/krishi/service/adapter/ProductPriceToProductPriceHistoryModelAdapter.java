package com.mycomp.krishi.service.adapter;

import java.util.Date;
import java.util.function.Function;

import com.mycomp.krishi.service.model.ProductPriceHistoryModel;
import com.mycomp.krishi.service.model.ProductPriceModel;

public final class ProductPriceToProductPriceHistoryModelAdapter implements Function<ProductPriceModel, ProductPriceHistoryModel> {
	public static ProductPriceToProductPriceHistoryModelAdapter INSTANCE = new ProductPriceToProductPriceHistoryModelAdapter();

	private ProductPriceToProductPriceHistoryModelAdapter() {
	}

	@Override
	public ProductPriceHistoryModel apply(ProductPriceModel model) {
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


}
