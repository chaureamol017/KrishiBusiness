import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: [
    './profile.component.scss',
    '../../common/commonStyle.scss',
    // '../../../common/commonStyle.scss',
  ]
})
export class ProfileComponent implements OnInit {
  formTitle: any = "My Profile";
  profileIndex = 0;

  constructor(
    private dialogRef: MatDialogRef<ProfileComponent>
  ) { }

  ngOnInit() {
    var refData = this.dialogRef._containerInstance._config.data;
  }

  
  updateProfileIndex($event) {
    this.profileIndex = $event;

  }
  closeDialog() {
    this.dialogRef.close();
  }
}
