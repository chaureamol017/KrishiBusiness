import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ChangePasswordComponent } from '../profile/change-password/change-password.component';
import { ProfileComponent } from '../profile/profile.component';
import { AdminService } from 'src/app/services/admin.service';
import { DialogService } from 'src/app/services/dialog.service';
import { Router } from '@angular/router';
import { MyLoginComponent } from 'src/app/entry-components/my-login/my-login.component';
import { SignUpComponent } from 'src/app/entry-components/sign-up/sign-up.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: [
    './header.component.scss'
  ]
})
export class HeaderComponent implements OnInit {

  appName: string = "Krishi Business";
  isSidebarVisible: boolean = false;

  isLoggedIn: boolean = false;
  userName: string = "John Doe";

  @Output() onToggle: EventEmitter<boolean> = new EventEmitter();

  constructor(
    private dialogService: DialogService,
    private adminService: AdminService,
    ) { }

  ngOnInit() { }

  toggleSidebar() {
    this.isSidebarVisible = !this.isSidebarVisible;
    this.onToggle.emit(this.isSidebarVisible);
  }

  login() {
    this.dialogService.openDialog(MyLoginComponent, {}, true);
  }

  signUp() {
    this.dialogService.openDialog(SignUpComponent, {}, false);
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
