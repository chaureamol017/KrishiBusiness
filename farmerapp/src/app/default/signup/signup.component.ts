import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AdminService } from 'src/app/services/admin.service';
import { UserSignup } from 'src/app/classes/user-signup';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  signupForm;

  constructor(
    private adminService: AdminService,
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

      this.adminService.signUp(signupDetails)
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
