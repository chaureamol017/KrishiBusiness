import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { UserDetails } from 'src/app/model/user-details';
import { AdminApiService } from 'src/app/services/admin-api.service';
import { AdminService } from 'src/app/services/admin.service';
import { FormValidationService } from 'src/app/services/form-validation.service';

@Component({
  selector: 'app-my-login',
  templateUrl: './my-login.component.html',
  styleUrls: ['./my-login.component.scss']
})

export class MyLoginComponent implements OnInit {
  formTitle: any = "Login";
  loginForm: FormGroup;
  loggedInUser: UserDetails = new UserDetails();

  constructor(
    private adminService: AdminService,
    private adminApiService: AdminApiService,
    private validationService: FormValidationService,
    private dialogRef: MatDialogRef<MyLoginComponent>,
  ) {
  }

  ngOnInit() {
    this.loginForm = this.validationService.getMyLoginFormGroup();
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
              this.closeDialog();
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

  closeDialog() {
    this.dialogRef.close();
  }
}
