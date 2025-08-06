import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FarmerProductService {
  serverUrl: any = "http://localhost:8080/";
  getByUserEndpoint: any = "byuser";
  getSoldByUserEndpoint: any = "soldbyuser";
  apiEndpoint: any = "v1/farmer_product";

  constructor(
    private httpCllient: HttpClient,
  ) { }

  
  getProducts1(): Observable<any> {
    var url = this.serverUrl + this.apiEndpoint + '/all';
    return this.httpCllient.get(url);
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

  saveProduct1(productDetails): Observable<any> {
    var url = this.serverUrl + this.apiEndpoint;

    return this.httpCllient.post(url, productDetails);
  }

  
  updateProduct1(productDetails): Observable<any> {
    var url = this.serverUrl + this.apiEndpoint;

    return this.httpCllient.put(url, productDetails);
  }

  deleteProduct1(productId): Observable<any> {
    var url = this.serverUrl + this.apiEndpoint + "/" + productId;

    return this.httpCllient.delete(url);
  }
}
