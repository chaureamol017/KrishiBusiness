import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserSignup } from 'src/app/model/user-signup';
import { AdminApiService } from 'src/app/services/admin-api.service';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  signupForm;

  constructor(
    private adminService: AdminService,
    private adminApiService: AdminApiService,
  ) { }

  ngOnInit() {
    this.signupForm = new FormGroup({
      role: new FormControl('', [Validators.required]),
      firstName: new FormControl('', [Validators.required]),
      middleName: new FormControl(''),
      lastName: new FormControl('', [Validators.required]),
      emailId: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
      confirmPassword: new FormControl('', [Validators.required]),
    });
  }
  signupUser(signupData) {
    var formValues = signupData.value;

    if (!formValues.password || !formValues.confirmPassword) {
      alert("Please add password.");
    } else if (formValues.password != formValues.confirmPassword) {
      alert("Password does not match.")
    } else {
      var signupDetails = new UserSignup();
      signupDetails.role = formValues.role;
      signupDetails.firstName = formValues.firstName;
      signupDetails.middleName = formValues.middleName;
      signupDetails.lastName = formValues.lastName;
      signupDetails.emailId = formValues.emailId;
      signupDetails.mobile = formValues.mobile;
      signupDetails.password = formValues.password;

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
}
