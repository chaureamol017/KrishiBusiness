import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LocalStorageService } from '../../../services/local-storage.service';
import { UserApiService } from '../../../services/user-api.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {
  @Output() closeProfileDialogForMe: EventEmitter<any> = new EventEmitter();

  userDetailsForm;

  constructor(
    private localStorageService: LocalStorageService,
    private userApiService: UserApiService
  ) {
    const firstName = this.localStorageService.getFirstName();
    const middleName = this.localStorageService.getMiddleName();
    const lastName = this.localStorageService.getLastName();
    const emailId = this.localStorageService.getEmailId();
    const mobile = this.localStorageService.getMobile();

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
    const userId: number = this.localStorageService.getUserId();
    const registrationFor: string = this.localStorageService.getRole();

    const userDetailsData = {
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
