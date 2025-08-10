export interface FarmerProductBid {
	farmerProductBidId: number,
	farmerProductId: number,
	buyerUserId: number,
	quotedPricePerUnit: number,
	bidOn: Date,
	acceptedOn: Date,
	accepted: Boolean,
}

export interface FarmerProductBidRequest {
	farmerProductBidId?: number,
	farmerProductId: number,
	buyerUserId: number,
	quotedPricePerUnit: number,
	bidOn: Date,
}

export interface FarmerProductBUyer {
	userId: number,
    role: string;
    firstName: string;
    middleName: string;
    lastName: string;
    emailId: string;
    mobile: string;
}

export interface ViewFarmerProductBid {
	bids: FarmerProductBid[],
	buyers: FarmerProductBUyer[],
}
