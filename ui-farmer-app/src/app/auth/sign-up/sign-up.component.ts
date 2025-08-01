import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { AdminService } from 'src/app/services/admin.service';
import { AuthService } from 'src/app/services/auth.service';
import { FormValidationService } from 'src/app/services/form-validation.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent {
  formTitle: any = "Sign up";
  signupForm: FormGroup;

  constructor(
    private adminService: AdminService,
    private adminApiService: AuthService,
    private formValidationService: FormValidationService,
    private dialogRef: MatDialogRef<SignUpComponent>
  ) {
    this.signupForm = this.formValidationService.getSignUpFormGroup();
  }

  ngOnInit() {
    
  }

  signupUser(signupData: FormGroup) {
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
