import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/home/login/login.component';
import { SignUpComponent } from 'src/app/home/sign-up/sign-up.component';
import { DialogService } from 'src/app/services/dialog.service';

@Component({
  selector: 'app-default-header',
  templateUrl: './default-header.component.html',
  styleUrls: ['./default-header.component.scss']
})
export class DefaultHeaderComponent implements OnInit {
  appName: any = "Krishi Business";

  constructor(private dialogService: DialogService) { }

  ngOnInit() {
  }

  login() {
    this.dialogService.openDialog(LoginComponent, {}, false);
  }

  signUp() {
    this.dialogService.openDialog(SignUpComponent, {}, false);
  }
}
