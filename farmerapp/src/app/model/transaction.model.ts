export interface Transaction {
  transactionId: number;
  farmerProductId: number;
  productName: string;
  category: string;
  quantity: number;
  quantityUnit: string;
  pricePerUnit: number;
  totalAmount: number;
  city: string;
  sellerUserId: number;
  sellerName: string;
  buyerUserId: number;
  buyerName: string;
  quotedPricePerUnit: number;
  soldOn: Date;
  bidAcceptedOn: Date;
}
