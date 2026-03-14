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

  // Forgot password
  showForgotPassword: boolean = false;
  forgotEmail: string = '';
  forgotMessage: string = '';
  forgotError: string = '';
  isForgotLoading: boolean = false;

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
    if (response && response.token && response.userDetails) {
      // New JWT response format: { token, userDetails }
      this.loggedInUser = response.userDetails;
      this.localStorageService.onValidateCall(this.loggedInUser, response.token);
      this.closeDialog();
    } else if (response && response.userId) {
      // Fallback: old format (plain user object)
      this.loggedInUser = response;
      this.localStorageService.onValidateCall(this.loggedInUser);
      this.closeDialog();
    } else {
      this.errorMessage = 'Invalid email or password. Please try again.';
    }
  }

  openForgotPassword() {
    this.showForgotPassword = true;
    this.forgotMessage = '';
    this.forgotError = '';
    this.forgotEmail = '';
  }

  backToLogin() {
    this.showForgotPassword = false;
    this.errorMessage = '';
  }

  submitForgotPassword() {
    this.forgotMessage = '';
    this.forgotError = '';
    if (!this.forgotEmail || this.forgotEmail.trim().length === 0) {
      this.forgotError = 'Please enter your email address.';
      return;
    }
    this.isForgotLoading = true;
    this.adminApiService.forgotPassword(this.forgotEmail.trim()).subscribe(
      (response: any) => {
        this.isForgotLoading = false;
        if (response && response.success) {
          this.forgotMessage = `Password reset! Your new default password is: ${response.defaultPassword}`;
        } else {
          this.forgotError = (response && response.message) ? response.message : 'Failed to reset password.';
        }
      },
      error => {
        this.isForgotLoading = false;
        this.forgotError = 'Could not connect to server. Please try again.';
      }
    );
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
