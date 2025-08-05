package com.mycomp.krishi.web.v1.adapter;

import com.mycomp.krishi.common.adapter.WebAdapter;
import com.mycomp.krishi.service.model.FarmerProductBidModel;
import com.mycomp.krishi.web.v1.model.FarmerProductBidRequest;
import com.mycomp.krishi.web.v1.model.FarmerProductBidResponse;

public class FarmerProductBidWebAdapter implements WebAdapter<FarmerProductBidRequest, FarmerProductBidResponse, FarmerProductBidModel> {

	public static final FarmerProductBidWebAdapter INSTANCE = new FarmerProductBidWebAdapter();

	private FarmerProductBidWebAdapter() {
	}
	public FarmerProductBidResponse toWeb(final FarmerProductBidModel model) {
		if (null == model) {
			return null;
		}
		final FarmerProductBidResponse web = new FarmerProductBidResponse();

		web.setFarmerProductBidId(model.getFarmerProductBidId());
		web.setFarmerProductId(model.getFarmerProductId());
		web.setBuyerUserId(model.getBuyerUserId());
		web.setQuotedPricePerUnit(model.getQuotedPricePerUnit());
		web.setBidOn(model.getBidOn());
		web.setAcceptedOn(model.getAcceptedOn());
		web.setAccepted(model.isAccepted());

		return web;
	}
	public FarmerProductBidModel toModel(final FarmerProductBidRequest web) {
		if (null == web) {
			return null;
		}
		final FarmerProductBidModel model = new FarmerProductBidModel();

		model.setFarmerProductBidId(web.getFarmerProductBidId());
		model.setFarmerProductId(web.getFarmerProductId());
		model.setBuyerUserId(web.getBuyerUserId());
		model.setQuotedPricePerUnit(web.getQuotedPricePerUnit());
		model.setBidOn(web.getBidOn());
		model.setAcceptedOn(web.getAcceptedOn());
		model.setAccepted(web.isAccepted());

		return model;
	}
}

