package com.mycomp.business.krishi.service.api.adaptor;

import java.sql.Timestamp;
import java.util.Date;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.entity.FarmerProductBid;
import com.mycomp.business.krishi.service.api.model.FarmerProductBidModel;

public class FarmerProductBidModelAdaptor implements ModelAdaptor<FarmerProductBidModel, FarmerProductBid> {
	public static final FarmerProductBidModelAdaptor INSTANCE = new FarmerProductBidModelAdaptor();

	private FarmerProductBidModelAdaptor() {
	}

	@Override
	public FarmerProductBid toEntityMinimal(FarmerProductBidModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductBid entity = createEntityWithouCopyingId(model);
		return entity;
	}

	@Override
	public FarmerProductBid toEntity(FarmerProductBidModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductBid entity = createEntityWithouCopyingId(model);
		entity.setFarmerProductBidId(model.getFarmerProductBidId());

		return entity;
	}

	@Override
	public FarmerProductBidModel toServiceModel(FarmerProductBid entity) {
		if (null == entity) {
			return null;
		}
		FarmerProductBidModel model = new FarmerProductBidModel();

		model.setFarmerProductBidId(entity.getFarmerProductBidId());
		model.setFarmerProductId(entity.getFarmerProductId());
		model.setBuyerUserId(entity.getBuyerUserId());
		model.setBiddingRate(entity.getBiddingRate());
		model.setBidOn(entity.getBidOn());
		model.setAccepted(entity.isAccepted());
		model.setAcceptedOn(entity.getAcceptedOn());

		return model;
	}
	
	public FarmerProductBid acceptBid(FarmerProductBid entity) {
		Timestamp acceptedOn = new Timestamp(new Date().getTime());

		entity.setAccepted(true);
		entity.setAcceptedOn(acceptedOn);
		
		return entity;
	}

	private static FarmerProductBid createEntityWithouCopyingId(FarmerProductBidModel model) {
		FarmerProductBid entity = new FarmerProductBid();

		entity.setFarmerProductId(model.getFarmerProductId());
		entity.setBuyerUserId(model.getBuyerUserId());
		entity.setBiddingRate(model.getBiddingRate());
		entity.setBidOn(model.getBidOn());
		entity.setAccepted(model.isAccepted());
		entity.setAcceptedOn(model.getAcceptedOn());
		return entity;
	}
}
