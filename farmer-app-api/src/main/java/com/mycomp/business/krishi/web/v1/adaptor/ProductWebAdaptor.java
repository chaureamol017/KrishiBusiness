package com.mycomp.business.krishi.web.v1.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.service.api.model.ProductModel;
import com.mycomp.business.krishi.web.v1.model.ProductWeb;

public class ProductWebAdaptor {

	public static List<ProductModel> toServiceModel(List<ProductWeb> webModels) {
		List<ProductModel> models = webModels.stream().map(web -> createServiceModel(web))
				.collect(Collectors.toList());

		return models;
	}

	public static ProductModel toServiceModel(ProductWeb web) {
		if (null == web) {
			return null;
		}
		ProductModel model = createServiceModel(web);
		return model;
	}

	public static List<ProductWeb> toWebModel(List<ProductModel> models) {
		if (null == models) {
			return null;
		}

		List<ProductWeb> webModels = models.stream()
				.map(model -> createWebModel(model))
				.collect(Collectors.toList());

		return webModels;
	}

	public static ProductWeb toWebModel(ProductModel model) {
		if (null == model) {
			return null;
		}

		return createWebModel(model);
	}

	
	
	private static ProductModel createServiceModel(ProductWeb web) {
		ProductModel model = new ProductModel();

		model.setProductId(web.getProductId());
		model.setProductName(web.getProductName());
		model.setDescription(web.getDescription());
//		model.setProductCategory(web.getProductCategory().toString());

		return model;
	}

	private static ProductWeb createWebModel(ProductModel model) {
		ProductWeb web = new ProductWeb();

		web.setProductId(model.getProductId());
		web.setProductName(model.getProductName());
		web.setDescription(model.getDescription());
		web.setProductCategory(model.getProductCategory());

		return web;
	}
}
