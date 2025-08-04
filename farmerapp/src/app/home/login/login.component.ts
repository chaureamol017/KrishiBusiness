import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { UserDetails } from 'src/app/model/user-details';
import { AdminApiService } from 'src/app/services/admin-api.service';
import { AuthService } from 'src/app/services/auth.service';
import { FormValidationService } from 'src/app/services/form-validation.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {
  formTitle: any = "Login";
  loginForm: FormGroup;
  loggedInUser: UserDetails = new UserDetails();

  constructor(
    private authService: AuthService,
    private adminApiService: AdminApiService,
    private validationService: FormValidationService,
    private dialogRef: MatDialogRef<LoginComponent>,
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
              this.authService.onValidateCall(this.loggedInUser);
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
