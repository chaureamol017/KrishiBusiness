import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../model/api-response.model';
import { Transaction } from '../model/transaction.model';
import { LocalStorageService } from './local-storage.service';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private serverUrl = 'http://localhost:8080/';
  private apiEndpoint = 'v1/transactions';

  constructor(
    private localStorageService: LocalStorageService,
    private httpClient: HttpClient,
  ) {}

  getSellerTransactions(): Observable<ApiResponse<Transaction[]>> {
    const userId = this.localStorageService.getUserId();
    const url = `${this.serverUrl}${this.apiEndpoint}/seller?userId=${userId}`;
    return this.httpClient.get<ApiResponse<Transaction[]>>(url);
  }

  getBuyerTransactions(): Observable<ApiResponse<Transaction[]>> {
    const userId = this.localStorageService.getUserId();
    const url = `${this.serverUrl}${this.apiEndpoint}/buyer?userId=${userId}`;
    return this.httpClient.get<ApiResponse<Transaction[]>>(url);
  }

  getAllTransactions(): Observable<ApiResponse<Transaction[]>> {
    const url = `${this.serverUrl}${this.apiEndpoint}/all`;
    return this.httpClient.get<ApiResponse<Transaction[]>>(url);
  }
}
