import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UserDetails } from '../model/user-details';
import { UserSignup } from '../model/user-signup';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private router: Router) { }

  onValidateCall(loggedInUser: UserDetails) {
    localStorage.setItem("userId", loggedInUser.userId ? loggedInUser.userId : "");
    localStorage.setItem("role", loggedInUser.role ? loggedInUser.role : "");
    localStorage.setItem("emailId", loggedInUser.emailId ? loggedInUser.emailId : "");
    localStorage.setItem("mobile", loggedInUser.mobile ? loggedInUser.mobile : "");
    localStorage.setItem("firstName", loggedInUser.firstName ? loggedInUser.firstName : "");
    localStorage.setItem("middleName", loggedInUser.middleName ? loggedInUser.middleName : "");
    localStorage.setItem("lastName", loggedInUser.lastName ? loggedInUser.lastName : "");

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

  createSignUpDetailsFromFormValues(formValues: any): UserSignup {
    var signupDetails: UserSignup = {
      role: formValues.role,
      firstName: formValues.firstName,
      middleName: formValues.middleName,
      lastName: formValues.lastName,
      emailId: formValues.emailId,
      mobile: formValues.mobile,
      password: formValues.password,
    }

    return signupDetails;
  }

  getRole(): string {
    return this.get("role")
  }

  getFirstName(): string {
    return this.get("firstName")
  }

  getMiddleName(): string {
    return this.get("middleName")
  }

  getLastName(): string {
    return this.get("lastName")
  }

  getEmailId(): string {
    return this.get("emailId")
  }

  private get(key: string): string {
    const data: string | null = localStorage.getItem(key);
    return data ? data : '';
  }
}
