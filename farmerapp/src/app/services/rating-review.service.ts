import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../model/api-response.model';
import { RatingReviewRequest, RatingReviewResponse } from '../model/rating-review.model';

@Injectable({
  providedIn: 'root'
})
export class RatingReviewService {
  private serverUrl = 'http://localhost:8080/';
  private apiEndpoint = 'v1/ratings';

  constructor(private httpClient: HttpClient) {}

  addRatingReview(request: RatingReviewRequest): Observable<ApiResponse<RatingReviewResponse>> {
    const url = `${this.serverUrl}${this.apiEndpoint}`;
    return this.httpClient.post<ApiResponse<RatingReviewResponse>>(url, request);
  }

  getReviewsForUser(userId: number): Observable<ApiResponse<RatingReviewResponse[]>> {
    const url = `${this.serverUrl}${this.apiEndpoint}/user/${userId}`;
    return this.httpClient.get<ApiResponse<RatingReviewResponse[]>>(url);
  }

  getReviewsForProduct(farmerProductId: number): Observable<ApiResponse<RatingReviewResponse[]>> {
    const url = `${this.serverUrl}${this.apiEndpoint}/product/${farmerProductId}`;
    return this.httpClient.get<ApiResponse<RatingReviewResponse[]>>(url);
  }

  getAverageRating(userId: number): Observable<ApiResponse<number>> {
    const url = `${this.serverUrl}${this.apiEndpoint}/average/${userId}`;
    return this.httpClient.get<ApiResponse<number>>(url);
  }
}
