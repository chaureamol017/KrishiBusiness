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
  getByUserEndpoint: any = "byuser";
  getSoldByUserEndpoint: any = "soldbyuser";
  apiEndpoint: any = "v1/farmer-product";

  constructor(
    private localStorageService: LocalStorageService,
    private httpCllient: HttpClient,
  ) { }

  
  getProductToSell(): Observable<FarmerProduct[]> {
    var url = this.serverUrl + this.apiEndpoint + '/sell?userId=' + this.localStorageService.getUserId();
    return this.httpCllient.get<FarmerProduct[]>(url);
  }

  getAllUnsoldProducts(): Observable<any> {
    var url = this.serverUrl + "allunsold";

    return this.httpCllient.get(url);
  }

  getSoldProducts(): Observable<any> {
    var userId: string = localStorage.getItem("userId");
    var parameters = "userId=" + userId;

    var url = this.serverUrl + this.getSoldByUserEndpoint + "?" + parameters;

    return this.httpCllient.get(url);
  }

  addFarmerProduct(product: FarmerProductRequest): Observable<FarmerProduct> {
    var url = this.serverUrl + this.apiEndpoint;

    return this.httpCllient.post<FarmerProduct>(url, product);
  }

  
  updateFarmerProduct(productDetails): Observable<FarmerProduct> {
    var url = this.serverUrl + this.apiEndpoint;

    return this.httpCllient.put<FarmerProduct>(url, productDetails);
  }

  deleteProduct1(productId): Observable<any> {
    var url = this.serverUrl + this.apiEndpoint + "/" + productId;

    return this.httpCllient.delete(url);
  }
}
