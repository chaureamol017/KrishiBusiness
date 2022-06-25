package com.mycomp.krishi.service.adapter;

import java.sql.Timestamp;
import java.util.Date;

import com.mycomp.krishi.persistence.entity.FarmerProductBid;

public class FarmerProductBidHelper {
	public static final FarmerProductBidHelper INSTANCE = new FarmerProductBidHelper();
	
	private FarmerProductBidHelper() {
	}

	public FarmerProductBid acceptBid(FarmerProductBid entity) {
		Timestamp acceptedOn = new Timestamp(new Date().getTime());

		entity.setAccepted(true);
		entity.setAcceptedOn(acceptedOn);
		
		return entity;
	}
}
