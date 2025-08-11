import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserApiService } from '../../../services/user-api.service';
import { LocalStorageService } from '../../../services/local-storage.service';

@Component({
  selector: 'app-address-details',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.scss']
})
export class AddressDetailsComponent implements OnInit {
  @Output() closeProfileDialogForMe: EventEmitter<any> = new EventEmitter();

  addressDetailsForm;

  constructor(
    private localStorageService: LocalStorageService,
    private userApiService: UserApiService
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
    this.userApiService.getAddressDetails()
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
    const userId = this.localStorageService.getUserId();
    const addressDetails = addressDetailsForm.value;

    const addressDetailsData = {
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

    this.userApiService.saveAddressDetails(addressDetailsData).subscribe(
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
      const addressDetails = eval("(" + responseData.data + ")");

      const userAddressDetailsId = (addressDetails.userAddressDetailsId) ? addressDetails.userAddressDetailsId : "";
      const addressLine1 = (addressDetails.addressLine1) ? addressDetails.addressLine1 : "";
      const addressLine2 = (addressDetails.addressLine2) ? addressDetails.addressLine2 : "";
      const locality = (addressDetails.locality) ? addressDetails.locality : "";
      const cityName = (addressDetails.cityName) ? addressDetails.cityName : "";
      const tahsilName = (addressDetails.tahsilName) ? addressDetails.tahsilName : "";
      const stateName = (addressDetails.stateName) ? addressDetails.stateName : "";
      const pincode = (addressDetails.pincode) ? addressDetails.pincode : "";

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
