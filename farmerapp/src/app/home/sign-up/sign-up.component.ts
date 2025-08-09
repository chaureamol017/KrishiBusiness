import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { UserSignup } from '../../model/user-signup';
import { UserAuthService } from '../../services/user-auth.service';
import { AuthUtil } from '../../util/auth-util';
import { SnackBarService } from '../../services/snack-bar.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss'],
  host: {
    'class': 'flex-column-stretch-gap',
  }
})
export class SignUpComponent implements OnInit {
  formTitle: any = "Sign up";
  signupForm: FormGroup;

  constructor(
    private snackBarService: SnackBarService,
    private adminApiService: UserAuthService,
    private dialogRef: MatDialogRef<SignUpComponent>
  ) { }

  ngOnInit() {
    this.signupForm = AuthUtil.getSignUpFormGroup();
  }

  signupUser() {
    const [isValid, message] = AuthUtil.isValidPassword(this.signupForm);

    if (!isValid) {
      this.snackBarService.openTopCenter(message, 'OK');
      return;
    }

    const signupDetails: UserSignup = AuthUtil.createSignUpDetailsFromFormValues(this.signupForm);
    this.adminApiService.signUp(signupDetails)
      .subscribe(response => this.signupSuccess(response), error => this.signupFailure(error));
  }

  signupSuccess(response) {
    if (response.success) {
      this.snackBarService.notify("Sign up successfull. Please login now!!!");
      this.closeDialog()
    } else {
      this.snackBarService.notify(response.message);
    }
  }

  signupFailure(error) {
    this.snackBarService.openTopCenter("Error ocurred while processing.");
  }

  closeDialog() {
    this.dialogRef.close();
  }
}
