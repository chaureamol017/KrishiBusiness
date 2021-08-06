import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ChangePasswordComponent } from '../../profile/change-password/change-password.component';
import { ProfileComponent } from '../../profile/profile.component';
import { AdminService } from 'src/app/services/admin.service';
import { DialogService } from 'src/app/services/dialog.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: [
    './header.component.scss'
  ]
})
export class HeaderComponent implements OnInit {

  appName: any = "Krishi Business";

  @Output() toggleSideBarForMe: EventEmitter<any> = new EventEmitter();

  constructor(private dialogService: DialogService,
    private adminService: AdminService,
    ) { }

  ngOnInit() { }

  toggleSideBar() {
    this.toggleSideBarForMe.emit();
  }

  
  openMyProfile() {
    var selectedData = {};
    this.dialogService.openDialogAtRight(ProfileComponent, selectedData, true);
  }
  changePassword () {
    var selectedData = {};
    this.dialogService.openDialog(ChangePasswordComponent, selectedData, false);
  }
  logOut () {
    this.adminService.logOut();
  }
}
