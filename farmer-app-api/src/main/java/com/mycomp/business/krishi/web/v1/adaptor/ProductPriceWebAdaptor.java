package com.mycomp.business.krishi.web.v1.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.service.api.model.ProductPriceModel;
import com.mycomp.business.krishi.web.v1.model.ProductPriceWeb;

public class ProductPriceWebAdaptor {

	public static List<ProductPriceModel> toServiceModel(List<ProductPriceWeb> webModels) {
		List<ProductPriceModel> models = webModels.stream().map(web -> createServiceModel(web))
				.collect(Collectors.toList());

		return models;
	}

	public static ProductPriceModel toServiceModel(ProductPriceWeb web) {
		if (null == web) {
			return null;
		}
		ProductPriceModel model = createServiceModel(web);
		return model;
	}

	public static List<ProductPriceWeb> toWebModel(List<ProductPriceModel> models) {
		if (null == models) {
			return null;
		}

		List<ProductPriceWeb> webModels = models.stream()
				.map(model -> createWebModel(model))
				.collect(Collectors.toList());

		return webModels;
	}

	public static ProductPriceWeb toWebModel(ProductPriceModel model) {
		if (null == model) {
			return null;
		}

		return createWebModel(model);
	}

	
	
	private static ProductPriceModel createServiceModel(ProductPriceWeb web) {
		ProductPriceModel model = new ProductPriceModel();

		model.setProductPriceId(web.getProductPriceId());
		model.setProductId(web.getProductId());
		model.setMinimumPrice(web.getMinimumPrice());
		model.setMaximumPrice(web.getMaximumPrice());

		return model;
	}

	private static ProductPriceWeb createWebModel(ProductPriceModel model) {
		ProductPriceWeb web = new ProductPriceWeb();

		web.setProductPriceId(model.getProductPriceId());
		web.setProductId(model.getProductId());
		web.setMinimumPrice(model.getMinimumPrice());
		web.setMaximumPrice(model.getMaximumPrice());

		return web;
	}
}
