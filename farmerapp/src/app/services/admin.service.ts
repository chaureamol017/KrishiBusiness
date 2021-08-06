import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UserDetails } from '../model/user-details';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private router: Router) { }

  onValidateCall(loggedInUser: UserDetails) {
    localStorage.setItem("userId", loggedInUser.userId);
    localStorage.setItem("role", loggedInUser.role);
    localStorage.setItem("emailId", loggedInUser.emailId);
    localStorage.setItem("mobile", loggedInUser.mobile);
    localStorage.setItem("firstName", loggedInUser.firstName);
    localStorage.setItem("middleName", loggedInUser.middleName);
    localStorage.setItem("lastName", loggedInUser.lastName);

    this.router.navigate(['MyHome']);
  }

  logOut() {
    localStorage.removeItem('token');

    localStorage.removeItem("userId");
    localStorage.removeItem("emailId");
    localStorage.removeItem("mobile");
    localStorage.removeItem("firstName");
    localStorage.removeItem("middleName");
    localStorage.removeItem("lastName");

    this.router.navigate(['']);
  }
}
