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
  errorMessage: string = '';
  isLoading: boolean = false;

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
    this.errorMessage = '';
    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched();
      return;
    }
    if (loginData) {
      this.isLoading = true;
      var userName = loginData.value.userName;
      var password = loginData.value.password;
      this.adminApiService.validateLogin(userName, password)
        .subscribe(
          response => this.handleSuccess(response),
          error => {
            this.isLoading = false;
            this.errorMessage = 'Invalid email or password. Please try again.';
          }
        );
    }
  }

  handleSuccess(response) {
    this.isLoading = false;
    if (response) {
      this.loggedInUser = response;
      this.localStorageService.onValidateCall(this.loggedInUser);
      this.closeDialog();
    } else {
      this.errorMessage = 'Invalid email or password. Please try again.';
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
