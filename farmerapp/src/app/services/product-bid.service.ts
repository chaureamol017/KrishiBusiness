import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FarmerProduct } from '../model/farmer-product';
import { FarmerProductBid, FarmerProductBidRequest } from '../model/farmer-product-bid.model';
import { LocalStorageService } from './local-storage.service';
import { ApiResponse } from '../model/api-response.model';

@Injectable({
  providedIn: 'root'
})
export class ProductBidService {
  serverUrl: any = "http://localhost:8080/";
  apiEndpoint: any = "v1/farmer-product-bid";

  constructor(
    private localStorageService: LocalStorageService,
    private httpCllient: HttpClient,
  ) {
  }
  
  saveProductBid(request: FarmerProductBidRequest): Observable<ApiResponse<FarmerProductBid>> {
    const url = this.serverUrl + this.apiEndpoint;

    return this.httpCllient.post<ApiResponse<FarmerProductBid>>(url, request);
  }

  updateProductBid(request: FarmerProductBidRequest): Observable<ApiResponse<FarmerProductBid>> {
    const url = this.serverUrl + this.apiEndpoint;

    return this.httpCllient.put<ApiResponse<FarmerProductBid>>(url, request);
  }

  getBid(productId: number): Observable<FarmerProductBid> {
    const userId = this.localStorageService.getUserId();
    const url = this.serverUrl + this.apiEndpoint + `/user/${userId}/product/${productId}`;
    return this.httpCllient.get<FarmerProductBid>(url);
  }

}
