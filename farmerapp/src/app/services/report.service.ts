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

  getSellerReport(startDate?: Date, endDate?: Date): Observable<ApiResponse<SellerReport>> {
    const userId = this.localStorageService.getUserId();
    let url = `${this.serverUrl}${this.apiEndpoint}/seller?userId=${userId}`;
    if (startDate) { url += `&startDate=${this.formatDate(startDate)}`; }
    if (endDate) { url += `&endDate=${this.formatDate(endDate)}`; }
    return this.httpClient.get<ApiResponse<SellerReport>>(url);
  }

  getBuyerReport(startDate?: Date, endDate?: Date): Observable<ApiResponse<BuyerReport>> {
    const userId = this.localStorageService.getUserId();
    let url = `${this.serverUrl}${this.apiEndpoint}/buyer?userId=${userId}`;
    if (startDate) { url += `&startDate=${this.formatDate(startDate)}`; }
    if (endDate) { url += `&endDate=${this.formatDate(endDate)}`; }
    return this.httpClient.get<ApiResponse<BuyerReport>>(url);
  }

  getAdminReport(): Observable<ApiResponse<AdminReport>> {
    const url = `${this.serverUrl}${this.apiEndpoint}/admin`;
    return this.httpClient.get<ApiResponse<AdminReport>>(url);
  }

  private formatDate(date: Date): string {
    const y = date.getFullYear();
    const m = String(date.getMonth() + 1).padStart(2, '0');
    const d = String(date.getDate()).padStart(2, '0');
    return `${y}-${m}-${d}`;
  }
}
