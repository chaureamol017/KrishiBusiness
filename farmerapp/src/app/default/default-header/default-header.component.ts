import { Component, OnInit } from '@angular/core';
import { MyLoginComponent } from 'src/app/entry-components/my-login/my-login.component';
import { SignUpComponent } from 'src/app/entry-components/sign-up/sign-up.component';
import { DialogService } from 'src/app/services/dialog.service';

@Component({
  selector: 'app-default-header',
  templateUrl: './default-header.component.html',
  styleUrls: [
    './default-header.component.scss',
    '../../common/commonStyle.scss'
  ]
})
export class DefaultHeaderComponent implements OnInit {
  appName: any = "Krishi Business";

  constructor(private dialogService: DialogService) { }

  ngOnInit() {
  }

  login() {
    this.dialogService.openDialog(MyLoginComponent, {}, false);
  }

  signUp() {
    this.dialogService.openDialog(SignUpComponent, {}, false);
  }
}
