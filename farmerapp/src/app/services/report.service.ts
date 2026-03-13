import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../model/api-response.model';
import { AdminReport, BuyerReport, SellerReport } from '../model/report.model';
import { LocalStorageService } from './local-storage.service';

@Injectable({
  providedIn: 'root'
})
export class ReportService {
  private serverUrl = 'http://localhost:8080/';
  private apiEndpoint = 'v1/reports';

  constructor(
    private localStorageService: LocalStorageService,
    private httpClient: HttpClient,
  ) {}

  getSellerReport(): Observable<ApiResponse<SellerReport>> {
    const userId = this.localStorageService.getUserId();
    const url = `${this.serverUrl}${this.apiEndpoint}/seller?userId=${userId}`;
    return this.httpClient.get<ApiResponse<SellerReport>>(url);
  }

  getBuyerReport(): Observable<ApiResponse<BuyerReport>> {
    const userId = this.localStorageService.getUserId();
    const url = `${this.serverUrl}${this.apiEndpoint}/buyer?userId=${userId}`;
    return this.httpClient.get<ApiResponse<BuyerReport>>(url);
  }

  getAdminReport(): Observable<ApiResponse<AdminReport>> {
    const url = `${this.serverUrl}${this.apiEndpoint}/admin`;
    return this.httpClient.get<ApiResponse<AdminReport>>(url);
  }
}
