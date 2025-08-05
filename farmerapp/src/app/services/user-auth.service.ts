import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserSignup } from '../model/user-signup';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {
  serverUrl: any = "http://localhost:8080";
  loginEndpoint: any = "/v1/user/validate";
  signupEndpoint: any = "/v1/user/signup"

  constructor(
    private httpCllient: HttpClient,
  ) { }

  validateLogin(userName: string, password: string): Observable<any> {
    var parameters = "userName=" + userName + "&password=" + password;
    var url = this.serverUrl + this.loginEndpoint + "?" + parameters;

    return this.httpCllient.get(url);
  }

  signUp(signUpDetails: UserSignup): Observable<any> {
    var url = this.serverUrl + this.signupEndpoint;

    return this.httpCllient.post(url, signUpDetails);
  }

}
