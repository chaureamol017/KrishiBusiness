package com.mycomp.krishi.web.v1.adapter;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.service.model.FarmerProductBidModel;
import com.mycomp.krishi.web.v1.model.FarmerProductBidWeb;

public class FarmerProductBidWebAdapter implements WebAdapter<FarmerProductBidWeb, FarmerProductBidModel> {
	public static final FarmerProductBidWebAdapter INSTANCE = new FarmerProductBidWebAdapter();

	public FarmerProductBidWeb toWeb(FarmerProductBidModel model) {
		if (null == model) {
			return null;
		}
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

	public FarmerProductBidModel toModel(FarmerProductBidWeb web) {
		if (null == web) {
			return null;
		}
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
