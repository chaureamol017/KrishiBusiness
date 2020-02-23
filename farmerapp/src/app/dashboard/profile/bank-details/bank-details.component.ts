import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-bank-details',
  templateUrl: './bank-details.component.html',
  styleUrls: ['./bank-details.component.scss']
})
export class BankDetailsComponent implements OnInit {
  @Output() closeProfileDialogForMe: EventEmitter<any> = new EventEmitter();

  bankDetailsForm;

  constructor(
    private userService: UserService
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

    this.userService.getBankDetails()
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

    this.userService.saveBankDetails(bankDetailsData)
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
