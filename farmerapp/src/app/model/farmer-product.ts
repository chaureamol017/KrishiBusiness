import { Product } from "./product";

export interface FarmerProduct {

	farmerProductId: number,
	productId: number,
	userId: number,
	produc: Product,
	quantity: number,
	quantityUnit: String,
	pricePerUnit: number,
	expectedPricePerUnit: number,
	addedOn: Date,
	soldOn: Date,
	sold: Boolean,
}