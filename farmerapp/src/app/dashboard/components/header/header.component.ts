import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { MatDialogConfig, MatDialog } from '@angular/material';
import { ChangePasswordComponent } from '../../profile/change-password/change-password.component';
import { ProfileComponent } from '../../profile/profile.component';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: [
    './header.component.scss',
    '../../../common/commonStyle.scss'
  ]
})
export class HeaderComponent implements OnInit {

  appName: any = "Krishi Business";

  @Output() toggleSideBarForMe: EventEmitter<any> = new EventEmitter();

  constructor(
    private dialog: MatDialog,
    private adminService: AdminService,
    ) { }

  ngOnInit() { }

  toggleSideBar() {
    this.toggleSideBarForMe.emit();
  }

  
  openMyProfile() {
    var selectedData = {};
    this.openDialogWithConfig(ProfileComponent, selectedData, true, true);
  }
  changePassword (){
    var selectedData = {};
    this.openDialogWithConfig(ChangePasswordComponent, selectedData, false, false);
  }
  logOut (){
    this.adminService.logOut();
  }
  
  openDialogWithConfig(dialogComponent, selectedData, isEdit, viewAtRight) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    if (viewAtRight) {
      dialogConfig.width = "60%";
      dialogConfig.height = "100%";
      dialogConfig.position = { top: '0', right: '0' };
    } else {
      dialogConfig.width = "40%";
    }
    dialogConfig.data = {
      selectedData: selectedData,
      isEdit: isEdit
    }
    this.dialog.open(dialogComponent, dialogConfig);
  }
}
