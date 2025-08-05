import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  serverUrl: any = "http://localhost:8080/";
  getByUserEndpoint: any = "byuser";
  getSoldByUserEndpoint: any = "soldbyuser";
  productEndpoint: any = "v1/product";

  constructor(
    private httpCllient: HttpClient,
  ) { }

  getProducts(): Observable<Product[]> {
    var url = this.serverUrl + this.productEndpoint + '/all';
    return this.httpCllient.get<Product[]>(url);
  }

  saveProduct(product: Product): Observable<any> {
    var url = this.serverUrl + this.productEndpoint;

    return this.httpCllient.post(url, product);
  }

  updateProduct(product: Product): Observable<any> {
    var url = this.serverUrl + this.productEndpoint;

    return this.httpCllient.put(url, product);
  }
  

  
  getProducts1(): Observable<any> {
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

  saveProduct1(productDetails): Observable<any> {
    var url = this.serverUrl + this.productEndpoint;

    return this.httpCllient.post(url, productDetails);
  }

  
  updateProduct1(productDetails): Observable<any> {
    var url = this.serverUrl + this.productEndpoint;

    return this.httpCllient.put(url, productDetails);
  }

  deleteProduct(productId): Observable<any> {
    var url = this.serverUrl + this.productEndpoint + "/" + productId;

    return this.httpCllient.delete(url);
  }

}
