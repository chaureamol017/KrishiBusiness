package com.mycomp.krishi.web.v1.adapter;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.service.model.ProductPriceModel;
import com.mycomp.krishi.web.v1.model.ProductPriceWeb;

public class ProductPriceWebAdapter implements WebAdapter<ProductPriceWeb, ProductPriceModel> {
	public static final ProductPriceWebAdapter INSTANCE = new ProductPriceWebAdapter();

	private ProductPriceWebAdapter() {
	}

	public ProductPriceModel toModel(ProductPriceWeb web) {
		if (null == web) {
			return null;
		}

		ProductPriceModel model = new ProductPriceModel();

		model.setProductPriceId(web.getProductPriceId());
		model.setProductId(web.getProductId());
		model.setMinimumPrice(web.getMinimumPrice());
		model.setMaximumPrice(web.getMaximumPrice());

		return model;
	}

	public ProductPriceWeb toWeb(ProductPriceModel model) {
		if (null == model) {
			return null;
		}

		ProductPriceWeb web = new ProductPriceWeb();

		web.setProductPriceId(model.getProductPriceId());
		web.setProductId(model.getProductId());
		web.setMinimumPrice(model.getMinimumPrice());
		web.setMaximumPrice(model.getMaximumPrice());

		return web;
	}
}
