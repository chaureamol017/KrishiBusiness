import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductbidService {

  serverUrl: any = "http://localhost:8080/productbid/";
  getByUserEndpoint: any = "byuserandproduct";
  saveEndpoint: any = "save";
  acceptEndpoint: any = "accept";
  deleteEndpoint: any = "delete";

  constructor(
    private httpCllient: HttpClient,
  ) { }

  getProductBid(productId): Observable<any> {
    var userId: string = localStorage.getItem("userId");
    var parameters = "productId=" + productId + "&userId=" + userId;

    var url = this.serverUrl + this.getByUserEndpoint + "?" + parameters;

    return this.httpCllient.get(url);
  }
  
  saveProductBid(productBidDetails): Observable<any> {
    var url = this.serverUrl + this.saveEndpoint;

    return this.httpCllient.post(url, productBidDetails);
  }

}
