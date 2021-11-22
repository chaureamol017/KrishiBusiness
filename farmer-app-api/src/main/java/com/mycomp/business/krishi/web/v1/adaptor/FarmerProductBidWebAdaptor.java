package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.FarmerProductBidModel;
import com.mycomp.business.krishi.web.v1.model.FarmerProductBidWeb;

public class FarmerProductBidWebAdaptor implements WebAdaptor<FarmerProductBidWeb, FarmerProductBidModel> {
	public static final FarmerProductBidWebAdaptor INSTANCE = new FarmerProductBidWebAdaptor();

	public FarmerProductBidWeb toWebModel(FarmerProductBidModel model) {
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

	public FarmerProductBidModel toServiceModel(FarmerProductBidWeb web) {
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
