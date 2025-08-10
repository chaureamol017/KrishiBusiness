package com.mycomp.krishi.web.v1.model;

import com.mycomp.krishi.user.requests.UserWeb;

import java.util.List;

public class FarmerProductViewBid {
    private List<FarmerProductBidResponse> bids;
    private List<UserWeb> buyers;

    public FarmerProductViewBid(List<FarmerProductBidResponse> bids, List<UserWeb> buyers) {
        this.bids = bids;
        this.buyers = buyers;
    }

    public List<FarmerProductBidResponse> getBids() {
        return bids;
    }

    public void setBids(List<FarmerProductBidResponse> bids) {
        this.bids = bids;
    }

    public List<UserWeb> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<UserWeb> buyers) {
        this.buyers = buyers;
    }
}
