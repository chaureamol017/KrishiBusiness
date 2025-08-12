import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { UserDetails } from '../../model/user-details';
import { UserAuthService } from '../../services/user-auth.service';
import { LocalStorageService } from '../../services/local-storage.service';
import { SnackBarService } from 'src/app/services/snack-bar.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  host: {
    'class': 'flex-column-stretch-gap',
  }
})

export class LoginComponent implements OnInit {
  formTitle: any = "Login";
  loginForm: FormGroup;
  loggedInUser: UserDetails = new UserDetails();

  constructor(
    private snackBarService: SnackBarService,
    private localStorageService: LocalStorageService,
    private adminApiService: UserAuthService,
    private dialogRef: MatDialogRef<LoginComponent>,
  ) {
  }

  ngOnInit() {
    this.loginForm = this.getMyLoginFormGroup();
  }

  validateLogin(loginData) {
    if (loginData) {
      var userName = loginData.value.userName;
      var password = loginData.value.password;
      this.adminApiService.validateLogin(userName, password)
        .subscribe(response => this.handleSuccess(response),
          error => this.snackBarService.notify("Error ocurred while processing."));
    }
  }

  handleSuccess(response) {
    if (response) {
      this.loggedInUser = response;
      this.localStorageService.onValidateCall(this.loggedInUser);
      this.closeDialog();
    } else {
      this.snackBarService.notify("Email or password is incorrect", undefined, 4000)
    }
  }

  getMyLoginFormGroup(): FormGroup {
    return new FormGroup({
        userName: new FormControl('', [Validators.required]),
        password: new FormControl('', [Validators.required]),
      });
  }

  closeDialog() {
    this.dialogRef.close();
  }
}
