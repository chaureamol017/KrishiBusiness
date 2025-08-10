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
