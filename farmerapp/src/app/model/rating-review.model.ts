export interface RatingReviewRequest {
  ratingId?: number;
  farmerProductId: number;
  reviewerUserId: number;
  ratedUserId: number;
  rating: number;
  review: string;
}

export interface RatingReviewResponse {
  ratingId: number;
  farmerProductId: number;
  reviewerUserId: number;
  reviewerName: string;
  ratedUserId: number;
  ratedUserName: string;
  rating: number;
  review: string;
  createdOn: Date;
  productName: string;
}
