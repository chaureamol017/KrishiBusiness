package com.mycomp.business.krishi.web.v1.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.service.api.model.ProductPriceHistoryModel;
import com.mycomp.business.krishi.web.v1.model.ProductPriceHistoryWeb;

public class ProductPriceHistoryWebAdaptor {

	public static List<ProductPriceHistoryModel> toServiceModel(List<ProductPriceHistoryWeb> webModels) {
		List<ProductPriceHistoryModel> models = webModels.stream().map(web -> createServiceModel(web))
				.collect(Collectors.toList());

		return models;
	}

	public static ProductPriceHistoryModel toServiceModel(ProductPriceHistoryWeb web) {
		if (null == web) {
			return null;
		}
		ProductPriceHistoryModel model = createServiceModel(web);
		return model;
	}

	public static List<ProductPriceHistoryWeb> toWebModel(List<ProductPriceHistoryModel> models) {
		if (null == models) {
			return null;
		}

		List<ProductPriceHistoryWeb> webModels = models.stream()
				.map(model -> createWebModel(model))
				.collect(Collectors.toList());

		return webModels;
	}

	public static ProductPriceHistoryWeb toWebModel(ProductPriceHistoryModel model) {
		if (null == model) {
			return null;
		}

		return createWebModel(model);
	}

	
	
	private static ProductPriceHistoryModel createServiceModel(ProductPriceHistoryWeb web) {
		ProductPriceHistoryModel model = new ProductPriceHistoryModel();

		model.setProductPriceHistoryId(web.getProductPriceHistoryId());
		model.setProductId(web.getProductId());
		model.setMinimumPrice(web.getMinimumPrice());
		model.setMaximumPrice(web.getMaximumPrice());
		model.setPriceOn(web.getPriceOn());

		return model;
	}

	private static ProductPriceHistoryWeb createWebModel(ProductPriceHistoryModel model) {
		ProductPriceHistoryWeb web = new ProductPriceHistoryWeb();

		web.setProductPriceHistoryId(model.getProductPriceHistoryId());
		web.setProductId(model.getProductId());
		web.setMinimumPrice(model.getMinimumPrice());
		web.setMaximumPrice(model.getMaximumPrice());
		web.setPriceOn(model.getPriceOn());

		return web;
	}
}
