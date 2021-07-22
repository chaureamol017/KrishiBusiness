package com.mycomp.business.krishi.web.v1.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.service.api.model.FarmerProductBidModel;
import com.mycomp.business.krishi.web.v1.model.FarmerProductBidWeb;

public class FarmerProductBidWebAdaptor {

	public static List<FarmerProductBidWeb> toWebModel(List<FarmerProductBidModel> models) {
		if (null == models) {
			return null;
		}
		List<FarmerProductBidWeb> webModels = models.stream().map(model -> createWebModel(model))
				.collect(Collectors.toList());
		return webModels;
	}

	public static FarmerProductBidWeb toWebModel(FarmerProductBidModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductBidWeb entity = createWebModel(model);
		return entity;
	}

	public static List<FarmerProductBidModel> toServiceModel(List<FarmerProductBidWeb> webModels) {
		List<FarmerProductBidModel> models = webModels.stream().map(web -> createServiceModel(web))
				.collect(Collectors.toList());

		return models;
	}

	public static FarmerProductBidModel toServiceModel(FarmerProductBidWeb web) {
		if (null == web) {
			return null;
		}
		FarmerProductBidModel model = createServiceModel(web);
		return model;
	}

	private static FarmerProductBidWeb createWebModel(FarmerProductBidModel model) {
		FarmerProductBidWeb web = new FarmerProductBidWeb();

		web.setFarmerProductBidId(model.getFarmerProductBidId());
		web.setFarmerProductId(model.getFarmerProductId());
		web.setBuyerUserId(model.getBuyerUserId());
		web.setBiddingRate(model.getBiddingRate());
		web.setBidOn(model.getBidOn());
		web.setAccepted(model.isAccepted());
		web.setAcceptedOn(model.getAcceptedOn());

		return web;
	}

	private static FarmerProductBidModel createServiceModel(FarmerProductBidWeb web) {
		FarmerProductBidModel model = new FarmerProductBidModel();

		model.setFarmerProductBidId(web.getFarmerProductBidId());
		model.setFarmerProductId(web.getFarmerProductId());
		model.setBuyerUserId(web.getBuyerUserId());
		model.setBiddingRate(web.getBiddingRate());
		model.setBidOn(web.getBidOn());
		model.setAccepted(web.isAccepted());
		model.setAcceptedOn(web.getAcceptedOn());

		return model;
	}
}
