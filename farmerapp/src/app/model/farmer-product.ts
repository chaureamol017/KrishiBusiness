import { Product } from "./product";

export interface FarmerProduct {
	farmerProductId: number,
	userId: number,
	productId: number,
	product: Product,
	description: string,
	quantity: number,
	quantityUnit: String,
	pricePerUnit: number,
	city: string,
	expectedPricePerUnit: number,
	addedOn: Date,
	soldOn: Date,
	sold: Boolean,
}

export interface FarmerProductRequest {
	farmerProductId?: number,
	userId: number,
	productId: number,
	description: string,
	quantity: number,
	quantityUnit: String,
	pricePerUnit: number,
	city: string,
	expectedPricePerUnit?: number,
	addedOn?: Date,
}
