import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LocalStorageService } from './local-storage.service';
import { FarmerProductRequest, FarmerProduct } from '../model/farmer-product';

@Injectable({
  providedIn: 'root'
})
export class FarmerProductService {
  serverUrl: any = "http://localhost:8080/";
  apiEndpoint: any = "v1/farmer-product";

  constructor(
    private localStorageService: LocalStorageService,
    private httpCllient: HttpClient,
  ) {
  }
  
  addFarmerProduct(product: FarmerProductRequest): Observable<FarmerProduct> {
    const url = this.serverUrl + this.apiEndpoint;

    return this.httpCllient.post<FarmerProduct>(url, product);
  }

  updateFarmerProduct(product: FarmerProductRequest): Observable<FarmerProduct> {
    const url = this.serverUrl + this.apiEndpoint;

    return this.httpCllient.put<FarmerProduct>(url, product);
  }

  getProductToSell(): Observable<FarmerProduct[]> {
    const url = this.serverUrl + this.apiEndpoint + '/sell?userId=' + this.localStorageService.getUserId();
    return this.httpCllient.get<FarmerProduct[]>(url);
  }

  getProductToBuy(): Observable<FarmerProduct[]> {
    const url = this.serverUrl + this.apiEndpoint + '/buy?userId=' + this.localStorageService.getUserId();

    return this.httpCllient.get<FarmerProduct[]>(url);
  }


  deleteProduct(productId): Observable<boolean> {
    const url = this.serverUrl + this.apiEndpoint + "/" + productId;

    return this.httpCllient.delete<boolean>(url);
  }
}
