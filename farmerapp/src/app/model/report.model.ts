export interface ProductSalesDetail {
  productName: string;
  category: string;
  quantity: number;
  quantityUnit: string;
  pricePerUnit: number;
  city: string;
  addedOn: string;
  soldOn: string;
  sold: boolean;
  totalValue: number;
}

export interface SellerReport {
  totalProductsListed: number;
  totalProductsSold: number;
  totalProductsUnsold: number;
  totalRevenue: number;
  averagePricePerUnit: number;
  productSalesDetails: ProductSalesDetail[];
}

export interface BidDetail {
  farmerProductId: number;
  productName: string;
  category: string;
  quantityUnit: string;
  quotedPricePerUnit: number;
  bidOn: string;
  acceptedOn: string;
  accepted: boolean;
}

export interface BuyerReport {
  totalBidsPlaced: number;
  totalBidsAccepted: number;
  totalBidsPending: number;
  totalAmountSpent: number;
  averageQuotedPrice: number;
  bidDetails: BidDetail[];
}

export interface AdminReport {
  totalUsers: number;
  totalProducts: number;
  totalFarmerProducts: number;
  totalFarmerProductsSold: number;
  totalFarmerProductsUnsold: number;
  totalBids: number;
  totalAcceptedBids: number;
  platformTotalRevenue: number;
}
