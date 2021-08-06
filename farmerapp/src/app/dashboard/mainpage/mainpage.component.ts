import { Component, OnInit } from '@angular/core';
import { UserDetails } from 'src/app/model/user-details';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.scss']
})
export class MainpageComponent implements OnInit {
  sideBarOpen = true;
  sideBarIndex = 0;
  loggedInUser: UserDetails;
  constructor(
  ) {
    
    this.loggedInUser = new UserDetails();
    
    this.loggedInUser.firstName = localStorage.getItem("firstName");
    this.loggedInUser.middleName = localStorage.getItem("middleName");
    this.loggedInUser.lastName = localStorage.getItem("lastName");
    this.loggedInUser.emailId = localStorage.getItem("emailId");
    this.loggedInUser.registrationFor = localStorage.getItem("registrationFor");
    
  }

  ngOnInit() {
    
  }

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

  switchSideBarContent($event) {
    this.sideBarIndex = $event;
  }

}
