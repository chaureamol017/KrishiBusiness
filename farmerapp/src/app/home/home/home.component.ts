import { Component, OnInit } from '@angular/core';
// import { MatDialog, MatDialogConfig } from "@angular/material"

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  appName: any = "Krishi Business";
  canCreateAccount: any = false;
  accountQuestion: any = "Not member?";
  accountBtnText: any = "Sign Up";

  constructor(
    // private dilog: MatDialog
  ) { }

  ngOnInit() {
  }

  toggleAccountOptions() {
    if (this.canCreateAccount) {
      this.accountQuestion = "Not member?";
      this.accountBtnText = "Sign Up!!";
    } else {
      this.accountQuestion = "Already member?";
      this.accountBtnText = "Log In";
    }

    this.canCreateAccount = !this.canCreateAccount;
  }

}
