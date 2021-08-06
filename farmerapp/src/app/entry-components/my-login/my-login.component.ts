import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserDetails } from 'src/app/model/user-details';
import { AdminApiService } from 'src/app/services/admin-api.service';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-my-login',
  templateUrl: './my-login.component.html',
  styleUrls: ['./my-login.component.scss']
})

export class MyLoginComponent implements OnInit {
  loginForm;
  loggedInUser: UserDetails = new UserDetails();

  constructor(
    private adminService: AdminService,
    private adminApiService: AdminApiService,
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
      this.adminApiService.validateLogin(userName, password)
        .subscribe(
          responseData => {
            if (responseData) {
              this.loggedInUser = responseData;
              this.adminService.onValidateCall(this.loggedInUser);
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
