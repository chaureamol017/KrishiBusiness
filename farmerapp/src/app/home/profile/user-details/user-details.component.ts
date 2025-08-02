import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserApiService } from 'src/app/services/user-api.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {
  @Output() closeProfileDialogForMe: EventEmitter<any> = new EventEmitter();

  userDetailsForm;

  constructor(
    private userApiService: UserApiService
  ) {
    var firstName = localStorage.getItem("firstName") ? localStorage.getItem("firstName") : "";
    var middleName = localStorage.getItem("middleName") ? localStorage.getItem("middleName") : "";
    var lastName = localStorage.getItem("lastName") ? localStorage.getItem("lastName") : "";
    var emailId = localStorage.getItem("emailId") ? localStorage.getItem("emailId") : "";
    var mobile = localStorage.getItem("mobile") ? localStorage.getItem("mobile") : "";

    this.userDetailsForm = new FormGroup({
      firstName: new FormControl(firstName, [Validators.required]),
      middleName: new FormControl(middleName, []),
      lastName: new FormControl(lastName, [Validators.required]),
      emailId: new FormControl(emailId, [Validators.required]),
      mobile: new FormControl(mobile, [Validators.required]),
    });
  }

  ngOnInit() {
  }

  saveUserDetailsForm(userDetailsForm) {
    var userId: string = localStorage.getItem("userId");
    var registrationFor = localStorage.getItem("registrationFor");

    var userDetailsData = {
      userId: userId,
      registrationFor: registrationFor,
      firstName: (userDetailsForm.value.firstName) ? userDetailsForm.value.firstName : "",
      middleName: (userDetailsForm.value.middleName) ? userDetailsForm.value.middleName : "",
      lastName: (userDetailsForm.value.lastName) ? userDetailsForm.value.lastName : "",
      emailId: (userDetailsForm.value.emailId) ? userDetailsForm.value.emailId : "",
      mobile: (userDetailsForm.value.mobile) ? userDetailsForm.value.mobile : "",
    };

    this.saveUserDetails(userDetailsData);
  }
  saveUserDetails(userDetailsData) {
    this.userApiService.saveBankDetails(userDetailsData)
      .subscribe(
        responseData => {
          this.handleSuccessResponse(responseData);
        },
        error => {
          console.log("Error ocurred while processing.");
        }
      )
  }


  handleSuccessResponse(responseData) {
    if (responseData.success) {
      alert("Address details saved successfully.");
      this.closeDialog();
    } else {
      alert("Error ocurred while processing.");
    }
  }

  closeDialog() {
    this.closeProfileDialogForMe.emit();
  }
}
