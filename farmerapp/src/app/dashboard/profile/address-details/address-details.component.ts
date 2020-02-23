import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-address-details',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.scss']
})
export class AddressDetailsComponent implements OnInit {
  @Output() closeProfileDialogForMe: EventEmitter<any> = new EventEmitter();

  addressDetailsForm;

  constructor(
    private userService: UserService
  ) {

    this.createAddressDetailsFormControl("", "", "", "", "", "", "", "");
  }
  ngOnInit() {

    this.getAddressDetails();
  }
  createAddressDetailsFormControl(userAddressDetailsId, addressLine1, addressLine2, locality, cityName, tahsilName, stateName, pincode) {
    this.addressDetailsForm = new FormGroup({
      userAddressDetailsId: new FormControl(userAddressDetailsId, [Validators.required]),
      addressLine1: new FormControl(addressLine1, [Validators.required]),
      addressLine2: new FormControl(addressLine2, [Validators.required]),
      locality: new FormControl(locality, [Validators.required]),
      cityName: new FormControl(cityName, [Validators.required]),
      tahsilName: new FormControl(tahsilName, [Validators.required]),
      stateName: new FormControl(stateName, [Validators.required]),
      pincode: new FormControl(pincode, [Validators.required]),
    });
  }

  getAddressDetails() {
    this.userService.getAddressDetails()
      .subscribe(
        responseData => {
          this.handleSuccessResponseForGet(responseData);
        },
        error => {
          console.log("Error ocurred while processing.");
        }
      )
  }

  saveAddressDetailsForm(addressDetailsForm) {
    var userId: string = localStorage.getItem("userId");
    var addressDetails = addressDetailsForm.value;

    var addressDetailsData = {
      userId: userId,
      userAddressDetailsId: (addressDetails.userAddressDetailsId) ? addressDetails.userAddressDetailsId : "",
      addressLine1: (addressDetails.addressLine1) ? addressDetails.addressLine1 : "",
      addressLine2: (addressDetails.addressLine2) ? addressDetails.addressLine2 : "",
      locality: (addressDetails.locality) ? addressDetails.locality : "",
      cityName: (addressDetails.cityName) ? addressDetails.cityName : "",
      tahsilName: (addressDetails.tahsilName) ? addressDetails.tahsilName : "",
      stateName: (addressDetails.stateName) ? addressDetails.stateName : "",
      pincode: (addressDetails.pincode) ? addressDetails.pincode : ""
    };

    this.userService.saveAddressDetails(addressDetailsData).subscribe(
      responseData => {
        this.handleSuccessResponse(responseData);
      },
      error => {
        alert("Error ocurred while processing.");
      }
    )
  }

  handleSuccessResponseForGet(responseData) {
    if (responseData.success) {
      var addressDetails = eval("(" + responseData.data + ")");

      var userAddressDetailsId = (addressDetails.userAddressDetailsId) ? addressDetails.userAddressDetailsId : "";
      var addressLine1 = (addressDetails.addressLine1) ? addressDetails.addressLine1 : "";
      var addressLine2 = (addressDetails.addressLine2) ? addressDetails.addressLine2 : "";
      var locality = (addressDetails.locality) ? addressDetails.locality : "";
      var cityName = (addressDetails.cityName) ? addressDetails.cityName : "";
      var tahsilName = (addressDetails.tahsilName) ? addressDetails.tahsilName : "";
      var stateName = (addressDetails.stateName) ? addressDetails.stateName : "";
      var pincode = (addressDetails.pincode) ? addressDetails.pincode : "";

      this.createAddressDetailsFormControl(userAddressDetailsId, addressLine1, addressLine2, locality, cityName,
        tahsilName, stateName, pincode);
    } else {
      alert("Error ocurred while processing.")
    }
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
