import { Product } from "./product";

export interface FarmerProduct {

	farmerProductId: number,
	userId: number,
	productId: number,
	produc: Product,
	quantity: number,
	quantityUnit: String,
	pricePerUnit: number,
	expectedPricePerUnit: number,
	addedOn: Date,
	soldOn: Date,
	sold: Boolean,
}