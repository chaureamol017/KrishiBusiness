import { Component, OnInit } from '@angular/core';
import { UserDetails } from 'src/app/classes/user-details';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm;
  loggedInUser: UserDetails = new UserDetails();

  constructor(
    private router: Router,
    private adminService: AdminService,
  ) {
  }

  ngOnInit() {
    this.loginForm = new FormGroup({
      userName: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }

  validateLogin(loginData) {
    if (loginData) {
      var userName = loginData.value.userName;
      var password = loginData.value.password;
      this.adminService.validateLogin(userName, password)
        .subscribe(
          responseData => {
            if (responseData) {
              this.loggedInUser = responseData;

              localStorage.setItem("userId", this.loggedInUser.userId);
              localStorage.setItem("role", this.loggedInUser.role);
              localStorage.setItem("emailId", this.loggedInUser.emailId);
              localStorage.setItem("mobile", this.loggedInUser.mobile);
              localStorage.setItem("firstName", this.loggedInUser.firstName);
              localStorage.setItem("middleName", this.loggedInUser.middleName);
              localStorage.setItem("lastName", this.loggedInUser.lastName);


              this.router.navigate(['MyHome']);
            } else {
              alert("Email or password is incorrect")
            }
          },
          error => {
            alert("Error ocurred while processing.");
          }
        )
    }
  }

}
