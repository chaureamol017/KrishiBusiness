import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ChangePasswordComponent } from '../profile/change-password/change-password.component';
import { ProfileComponent } from '../profile/profile.component';
import { AuthService } from 'src/app/services/auth.service';
import { DialogService } from 'src/app/services/dialog.service';
import { LoginComponent } from 'src/app/home/login/login.component';
import { SignUpComponent } from 'src/app/home/sign-up/sign-up.component';

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

  @Output() onToggle: EventEmitter<boolean> = new EventEmitter();

  constructor(
    private dialogService: DialogService,
    private authService: AuthService,
    ) { }

  ngOnInit() {
    
  }

  toggleSidebar() {
    this.isSidebarVisible = !this.isSidebarVisible;
    this.onToggle.emit(this.isSidebarVisible);
  }

  login() {
    this.dialogService.openDialog(LoginComponent, {}, true);
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
    this.authService.logOut();
  }
}
