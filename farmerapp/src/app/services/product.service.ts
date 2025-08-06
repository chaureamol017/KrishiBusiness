import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  serverUrl: any = "http://localhost:8080/";
  productEndpoint: any = "v1/products";

  constructor(
    private httpCllient: HttpClient,
  ) { }

  getProducts(): Observable<Product[]> {
    var url = this.serverUrl + this.productEndpoint + '/all';
    return this.httpCllient.get<Product[]>(url);
  }

  saveProduct(product: Product): Observable<Product> {
    var url = this.serverUrl + this.productEndpoint;

    return this.httpCllient.post<Product>(url, product);
  }

  updateProduct(product: Product): Observable<Product> {
    var url = this.serverUrl + this.productEndpoint;

    return this.httpCllient.put<Product>(url, product);
  }

  deleteProduct(productId): Observable<any> {
    var url = this.serverUrl + this.productEndpoint + "/" + productId;

    return this.httpCllient.delete(url);
  }

}
