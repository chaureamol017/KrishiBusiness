import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  serverUrl: any = "http://localhost:8080/user/";
  getUserByIdEndpoint: any = "byid";
  passwordEndpoint: any = "changepassword";
  bankEndpoint: any = "bankdetails";
  addressEndpoint: any = "addressdetails";

  constructor(
    private httpCllient: HttpClient
  ) { }

  getUserById(id): Observable<any> {
    var parameters = "id=" + id;
    var url = this.serverUrl + this.getUserByIdEndpoint + "?" + parameters;

    return this.httpCllient.get(url);
  }

  changePassword(oldPassword, newPassword): Observable<any> {
    var userId: string = localStorage.getItem("userId");
    var userData = {
      userId: userId,
      oldPassword: oldPassword,
      newPassword: newPassword
    }

    var url = this.serverUrl + this.passwordEndpoint;

    return this.httpCllient.post(url,userData);
  }
  
  saveUserDetails(bankDetailsData): Observable<any> {
    var url = this.serverUrl + this.bankEndpoint;

    return this.httpCllient.post(url, bankDetailsData);
  }

  getBankDetails(): Observable<any> {
    var userId: string = localStorage.getItem("userId");
    var parameters = "userId=" + userId;
    var url = this.serverUrl + this.bankEndpoint + "?" + parameters;

    return this.httpCllient.get(url);
  }

  saveBankDetails(bankDetailsData): Observable<any> {
    var url = this.serverUrl + this.bankEndpoint;

    return this.httpCllient.put(url, bankDetailsData);
  }

  getAddressDetails(): Observable<any> {
    var userId: string = localStorage.getItem("userId");
    var parameters = "userId=" + userId;
    var url = this.serverUrl + this.addressEndpoint + "?" + parameters;

    return this.httpCllient.get(url);
  }
  
  saveAddressDetails(addressDetailsData): Observable<any> {
    var url = this.serverUrl + this.addressEndpoint;

    return this.httpCllient.post(url, addressDetailsData);
  }
}
