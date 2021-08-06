import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { UserSignup } from 'src/app/model/user-signup';
import { AdminApiService } from 'src/app/services/admin-api.service';
import { AdminService } from 'src/app/services/admin.service';
import { FormValidationService } from 'src/app/services/form-validation.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  formTitle: any = "Sign up";
  signupForm: FormGroup;

  constructor(
    private adminService: AdminService,
    private adminApiService: AdminApiService,
    private formValidationService: FormValidationService,
    private dialogRef: MatDialogRef<SignUpComponent>
  ) { }

  ngOnInit() {
    this.signupForm = this.formValidationService.getSignUpFormGroup();
  }

  signupUser(signupData) {
    var formValues = signupData.value;

    if (!formValues.password || !formValues.confirmPassword) {
      alert("Please add password.");
    } else if (formValues.password != formValues.confirmPassword) {
      alert("Password does not match.")
    } else {
      var signupDetails = this.adminService.createSignUpDetailsFromFormValues(formValues);

      this.adminApiService.signUp(signupDetails)
        .subscribe(
          responseData => {
            if (responseData.success) {
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
