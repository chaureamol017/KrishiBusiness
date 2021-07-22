package com.mycomp.business.krishi.web.v1.adaptor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.service.api.model.FarmerProductModel;
import com.mycomp.business.krishi.web.v1.model.FarmerProductWeb;

public class FarmerProductWebAdaptor {

	public static List<FarmerProductWeb> toWebModel(List<FarmerProductModel> models) {
		if (null == models) {
			return null;
		}
		List<FarmerProductWeb> webModels = models.stream().map(model -> createWebModel(model))
				.collect(Collectors.toList());
		return webModels;
	}

	public static FarmerProductWeb toWebModel(FarmerProductModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductWeb web = createWebModel(model);
		return web;
	}

	public static List<FarmerProductModel> toServiceModel(List<FarmerProductWeb> webModels) {
		List<FarmerProductModel> models = webModels.stream().map(web -> createServiceModel(web))
				.collect(Collectors.toList());

		return models;
	}

	public static FarmerProductModel toServiceModel(FarmerProductWeb web) {
		if (null == web) {
			return null;
		}
		FarmerProductModel model = createServiceModel(web);
		return model;
	}

	private static FarmerProductWeb createWebModel(FarmerProductModel model) {
		FarmerProductWeb web = new FarmerProductWeb();

		web.setFarmerProductId(model.getFarmerProductId());
		web.setProductId(model.getProductId());
		web.setUserId(model.getUserId());
		web.setProductQuantity(model.getProductQuantity());
		web.setExpectedPrice(model.getExpectedPrice());
		web.setAddedOn(new java.sql.Timestamp(new Date().getTime()));
		web.setSold(false);

		return web;
	}

	private static FarmerProductModel createServiceModel(FarmerProductWeb web) {
		FarmerProductModel model = new FarmerProductModel();

		model.setFarmerProductId(web.getFarmerProductId());
		model.setProductId(web.getProductId());
		model.setUserId(web.getUserId());
		model.setProductQuantity(web.getProductQuantity());
		model.setExpectedPrice(web.getExpectedPrice());
		model.setAddedOn(web.getAddedOn());
		model.setSold(web.isSold());
		model.setSoldOn(web.getSoldOn());

		return model;
	}
}
