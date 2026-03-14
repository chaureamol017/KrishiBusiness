import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LocalStorageService } from './local-storage.service';

@Injectable({
  providedIn: 'root'
})
export class UserApiService {
  serverUrl: any = "http://localhost:8080/";

  constructor(
    private localStorageService: LocalStorageService,
    private httpCllient: HttpClient
  ) { }

  getUserById(id): Observable<any> {
    const url = `${this.serverUrl}v1/user/byid/${id}`;
    return this.httpCllient.get(url);
  }

  changePassword(oldPassword, newPassword): Observable<any> {
    const userName = this.localStorageService.getEmailId();
    const body = { userName, oldPassword, newPassword };
    const url = `${this.serverUrl}v1/user/password/change`;
    return this.httpCllient.post(url, body);
  }

  saveUserDetails(userDetailsData): Observable<any> {
    const url = `${this.serverUrl}v1/user/update`;
    return this.httpCllient.put(url, userDetailsData);
  }

  getBankDetails(): Observable<any> {
    const userId = this.localStorageService.getUserId();
    const url = `${this.serverUrl}v1/bankdetails/byUserId/${userId}`;
    return this.httpCllient.get(url);
  }

  saveBankDetails(bankDetailsData): Observable<any> {
    const url = `${this.serverUrl}v1/bankdetails`;
    return this.httpCllient.put(url, bankDetailsData);
  }

  getAddressDetails(): Observable<any> {
    const userId = this.localStorageService.getUserId();
    const url = `${this.serverUrl}v1/address/addressDetails/byUserId/${userId}`;
    return this.httpCllient.get(url);
  }

  saveAddressDetails(addressDetailsData): Observable<any> {
    const url = `${this.serverUrl}v1/address/addressDetails`;
    return this.httpCllient.post(url, addressDetailsData);
  }
}
