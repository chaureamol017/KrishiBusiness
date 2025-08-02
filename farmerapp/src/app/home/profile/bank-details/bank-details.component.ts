import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { UserApiService } from 'src/app/services/user-api.service';

@Component({
  selector: 'app-bank-details',
  templateUrl: './bank-details.component.html',
  styleUrls: ['./bank-details.component.scss']
})
export class BankDetailsComponent implements OnInit {
  @Output() closeProfileDialogForMe: EventEmitter<any> = new EventEmitter();

  bankDetailsForm;

  constructor(
    private userApiService: UserApiService
  ) {
    this.createBankDetailsFormControl("", "", "", "");
  }

  ngOnInit() {
    this.getBankDetails();
  }

  createBankDetailsFormControl(userBankDetailsId, bankName, branchName, ifscCode) {
    this.bankDetailsForm = new FormGroup({
      userBankDetailsId: new FormControl(userBankDetailsId, [Validators.required]),
      bankName: new FormControl(bankName, [Validators.required]),
      branchName: new FormControl(branchName, [Validators.required]),
      ifscCode: new FormControl(ifscCode, [Validators.required]),
    });
  }

  getBankDetails() {

    this.userApiService.getBankDetails()
      .subscribe(
        responseData => {
          this.handleSuccessResponseForGet(responseData);
        },
        error => {
          console.log("Error ocurred while processing.");
        }
      )
  }

  saveBankDetailsForm(bankDetailsForm) {
    var userId: string = localStorage.getItem("userId");
    var userBankDetailsId = bankDetailsForm.value.userBankDetailsId;
    var bankName = bankDetailsForm.value.bankName;
    var branchName = bankDetailsForm.value.branchName;
    var ifscCode = bankDetailsForm.value.ifscCode;

    var bankDetailsData = {
      userId: userId,
      userBankDetailsId: userBankDetailsId,
      bankName: bankName,
      branchName: branchName,
      ifscCode: ifscCode
    };

    this.userApiService.saveBankDetails(bankDetailsData)
      .subscribe(
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
      var bankDetails = eval("(" + responseData.data + ")");
      var controls = this.bankDetailsForm.controls;
      var userBankDetailsId = (bankDetails.userBankDetailsId) ? bankDetails.userBankDetailsId : "";
      var bankName = (bankDetails.bankName) ? bankDetails.bankName : "";
      var branchName = (bankDetails.branchName) ? bankDetails.branchName : "";
      var ifscCode = (bankDetails.ifscCode) ? bankDetails.ifscCode : "";

      this.createBankDetailsFormControl(userBankDetailsId, bankName, branchName, ifscCode);
    } else {
      alert("Error ocurred while processing.")
    }
  }

  handleSuccessResponse(responseData) {
    if (responseData.success) {
      alert("Bank details saved successfully.");
      this.closeDialog();
    } else {
      alert("Error ocurred while processing.");
    }
  }

  closeDialog() {
    this.closeProfileDialogForMe.emit();
  }
}
