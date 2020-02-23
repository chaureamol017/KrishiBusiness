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
      emailId: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }

  validateLogin(loginData) {
    if (loginData) {
      var emailId = loginData.value.emailId;
      var password = loginData.value.password;
      this.adminService.validateLogin(emailId, password)
        .subscribe(
          responseData => {
            if (responseData.success) {
              this.loggedInUser = eval("(" + responseData.data + ")");

              localStorage.setItem("userId", this.loggedInUser.userId);
              localStorage.setItem("registrationFor", this.loggedInUser.registrationFor);
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
