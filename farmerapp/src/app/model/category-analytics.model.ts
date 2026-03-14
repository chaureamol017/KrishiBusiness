export interface CategoryDetail {
  category: string;
  totalProducts: number;
  totalSold: number;
  totalUnsold: number;
  totalRevenue: number;
  totalBids: number;
}

export interface CategoryAnalytics {
  productsByCategory: { [key: string]: number };
  soldByCategory: { [key: string]: number };
  revenueByCategory: { [key: string]: number };
  bidsByCategory: { [key: string]: number };
  categoryDetails: CategoryDetail[];
}
