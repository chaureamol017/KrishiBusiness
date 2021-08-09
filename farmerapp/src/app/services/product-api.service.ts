import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductApiService {

  serverUrl: any = "http://localhost:8080/";
  getByUserEndpoint: any = "byuser";
  getSoldByUserEndpoint: any = "soldbyuser";
  productEndpoint: any = "v1/product";

  constructor(
    private httpCllient: HttpClient,
  ) { }

  getProducts(): Observable<any> {
    var url = this.serverUrl + this.productEndpoint + '/all';
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

  saveProduct(productDetails): Observable<any> {
    var url = this.serverUrl + this.productEndpoint;

    return this.httpCllient.post(url, productDetails);
  }

  
  updateProduct(productDetails): Observable<any> {
    var url = this.serverUrl + this.productEndpoint;

    return this.httpCllient.put(url, productDetails);
  }

  deleteProduct(productId): Observable<any> {
    var url = this.serverUrl + this.productEndpoint + "/" + productId;

    return this.httpCllient.delete(url);
  }

}
