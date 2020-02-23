import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  serverUrl: any = "http://localhost:8080/product/";
  getByUserEndpoint: any = "byuser";
  getSoldByUserEndpoint: any = "soldbyuser";
  updateEndpoint: any = "update";
  deleteEndpoint: any = "delete";

  constructor(
    private httpCllient: HttpClient,
  ) { }

  getProducts(): Observable<any> {
    var userId: string = localStorage.getItem("userId");
    var parameters = "userId=" + userId;

    var url = this.serverUrl + this.getByUserEndpoint + "?" + parameters;

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
    var url = this.serverUrl + this.updateEndpoint;

    return this.httpCllient.put(url, productDetails);
  }
  deleteProduct(productId): Observable<any> {
    var params = "id=" + productId;
    var url = this.serverUrl + this.deleteEndpoint + "?" + params;

    return this.httpCllient.delete(url);
  }

}
