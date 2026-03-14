import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../model/api-response.model';
import { CategoryAnalytics } from '../model/category-analytics.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryAnalyticsService {
  private serverUrl = 'http://localhost:8080/';
  private apiEndpoint = 'v1/reports';

  constructor(private httpClient: HttpClient) {}

  getCategoryAnalytics(): Observable<ApiResponse<CategoryAnalytics>> {
    const url = `${this.serverUrl}${this.apiEndpoint}/category-analytics`;
    return this.httpClient.get<ApiResponse<CategoryAnalytics>>(url);
  }
}
