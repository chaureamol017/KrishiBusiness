package com.mycomp.krishi.service.adapter;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.FarmerProductBid;
import com.mycomp.krishi.service.model.FarmerProductBidModel;

public class FarmerProductBidModelAdapter implements ModelAdapter<FarmerProductBidModel, FarmerProductBid> {
	public static final FarmerProductBidModelAdapter INSTANCE = new FarmerProductBidModelAdapter();

	private FarmerProductBidModelAdapter() {
	}

	@Override
	public FarmerProductBid toEntityMinimal(FarmerProductBidModel model) {
		if (null == model) {
			return null;
		}

		FarmerProductBid entity = new FarmerProductBid();
		entity.setFarmerProductId(model.getFarmerProductId());
		entity.setBuyerUserId(model.getBuyerUserId());
		entity.setBiddingRate(model.getBiddingRate());
		entity.setBidOn(model.getBidOn());
		entity.setAccepted(model.isAccepted());
		entity.setAcceptedOn(model.getAcceptedOn());

		return entity;
	}

	@Override
	public FarmerProductBid toEntity(FarmerProductBidModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductBid entity = toEntityMinimal(model);
		entity.setFarmerProductBidId(model.getFarmerProductBidId());

		return entity;
	}

	@Override
	public FarmerProductBidModel toModel(FarmerProductBid entity) {
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
	

}
