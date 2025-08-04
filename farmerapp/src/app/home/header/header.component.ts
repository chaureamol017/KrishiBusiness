import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ChangePasswordComponent } from '../profile/change-password/change-password.component';
import { ProfileComponent } from '../profile/profile.component';
import { AuthService } from '../../services/auth.service';
import { DialogService } from '../../services/dialog.service';
import { LoginComponent } from '../../home/login/login.component';
import { SignUpComponent } from '../../home/sign-up/sign-up.component';

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
    if (this.isLoggedIn) {
      this.toggleSidebar();
    }
    
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
