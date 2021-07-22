package com.mycomp.business.krishi.web.v1.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.service.api.model.FarmerProductBuyerMapModel;
import com.mycomp.business.krishi.web.v1.model.FarmerProductBuyerMapWeb;

public class FarmerProductBuyerMapWebAdaptor {

	public static List<FarmerProductBuyerMapWeb> toWebModel(List<FarmerProductBuyerMapModel> models) {
		if (null == models) {
			return null;
		}
		List<FarmerProductBuyerMapWeb> webModels = models.stream().map(model -> createWebModel(model))
				.collect(Collectors.toList());
		return webModels;
	}

	public static FarmerProductBuyerMapWeb toWebModel(FarmerProductBuyerMapModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductBuyerMapWeb web = createWebModel(model);
		return web;
	}

	public static List<FarmerProductBuyerMapModel> toServiceModel(List<FarmerProductBuyerMapWeb> webModels) {
		List<FarmerProductBuyerMapModel> models = webModels.stream().map(entity -> createServiceModel(entity))
				.collect(Collectors.toList());

		return models;
	}

	public static FarmerProductBuyerMapModel toServiceModel(FarmerProductBuyerMapWeb web) {
		if (null == web) {
			return null;
		}
		FarmerProductBuyerMapModel model = createServiceModel(web);
		return model;
	}

	private static FarmerProductBuyerMapWeb createWebModel(FarmerProductBuyerMapModel model) {
		FarmerProductBuyerMapWeb web = new FarmerProductBuyerMapWeb();

		web.setFarmerProductBuyerMapId(model.getFarmerProductBuyerMapId());
		web.setFarmerProductId(model.getFarmerProductId());
		web.setBuyerUserId(model.getBuyerUserId());
		web.setSoldPrice(model.getSoldPrice());
		web.setSoldOn(model.getSoldOn());

		return web;
	}

	private static FarmerProductBuyerMapModel createServiceModel(FarmerProductBuyerMapWeb web) {
		FarmerProductBuyerMapModel model = new FarmerProductBuyerMapModel();

		model.setFarmerProductBuyerMapId(web.getFarmerProductBuyerMapId());
		model.setFarmerProductId(web.getFarmerProductId());
		model.setBuyerUserId(web.getBuyerUserId());
		model.setSoldPrice(web.getSoldPrice());
		model.setSoldOn(web.getSoldOn());

		return model;
	}
}
