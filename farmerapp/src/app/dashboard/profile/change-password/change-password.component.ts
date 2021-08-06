import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { UserApiService } from 'src/app/services/user-api.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.scss',
    '../../../common/commonStyle.scss']
})
export class ChangePasswordComponent implements OnInit {

  changepasswordForm;
  selectedData: any;
  formTitle: any = "Change Password";
  constructor(
    private userApiService: UserApiService,
    private dialogRef: MatDialogRef<ChangePasswordComponent>,
  ) { }

  ngOnInit() {
    var refData = this.dialogRef._containerInstance._config.data;
    this.selectedData = refData.selectedData;

    this.changepasswordForm = new FormGroup({
      oldPassword: new FormControl('', [Validators.required]),
      newPassword: new FormControl('', [Validators.required]),
      rePassword: new FormControl('', [Validators.required])
    });
  }

  changePassword(changepasswordForm) {
    var oldPassword = changepasswordForm.value.oldPassword;
    if (oldPassword) {

      var newPassword = changepasswordForm.value.newPassword;
      var rePassword = changepasswordForm.value.rePassword;
      if (!newPassword || !rePassword) {
        alert("Please enter password");
      } else if (newPassword != rePassword) {
        alert("New password and Re-Passwordshold be equal");
      } else {
        this.userApiService.changePassword(oldPassword, newPassword).subscribe(
          responseData => {
            this.handleSuccessResponse(responseData);
          },
          error => {
            alert("Error ocurred while processing.");
          }
        )
      }
    } else {
      alert("Please enter old password");
    }
  }

  handleSuccessResponse(responseData) {
    if (responseData.success) {
      var resp = eval("(" + responseData.data + ")");
      alert("Password changed successfully.");
      this.closeDialog();
    } else {
      var resp = eval("(" + responseData.data + ")");
      if (resp && resp.message) {
        alert(resp.message)
      } else {
        alert("Error ocurred while processing.");
      }
    }
  }

  closeDialog() {
    this.dialogRef.close();
  }
}
