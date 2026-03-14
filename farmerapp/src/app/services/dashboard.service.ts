import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../model/api-response.model';
import { LocalStorageService } from './local-storage.service';

export interface DashboardData {
  role: string;
  // Seller fields
  totalProductsListed?: number;
  totalProductsSold?: number;
  totalProductsUnsold?: number;
  totalRevenue?: number;
  // Buyer fields
  totalBidsPlaced?: number;
  totalBidsAccepted?: number;
  totalBidsPending?: number;
  totalAmountSpent?: number;
  // Admin fields
  totalUsers?: number;
  totalProducts?: number;
  totalFarmerProducts?: number;
  totalFarmerProductsSold?: number;
  totalBids?: number;
  totalAcceptedBids?: number;
  platformTotalRevenue?: number;
}

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  private serverUrl = 'http://localhost:8080/';
  private apiEndpoint = 'v1/dashboard';

  constructor(
    private localStorageService: LocalStorageService,
    private httpClient: HttpClient,
  ) {}

  getDashboard(): Observable<ApiResponse<DashboardData>> {
    const userId = this.localStorageService.getUserId();
    const role = this.localStorageService.getRole();
    const url = `${this.serverUrl}${this.apiEndpoint}?userId=${userId}&role=${role}`;
    return this.httpClient.get<ApiResponse<DashboardData>>(url);
  }
}
