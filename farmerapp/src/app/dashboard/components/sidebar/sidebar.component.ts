import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { UserDetails } from 'src/app/classes/user-details';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  @Output() switchSideBarForMe: EventEmitter<any> = new EventEmitter();
  @Input('loggedInUser') loggedInUser: UserDetails = new UserDetails();

  activeLink: any = 0; 
  loggedInUserName: any;
  loggedInUserEmail: any;
  constructor() { }

  ngOnInit() {
    this.activeLink = 0; 
    
    var firstName = (this.loggedInUser.firstName? this.loggedInUser.firstName : "" );
    var lastName = (this.loggedInUser.lastName? this.loggedInUser.lastName : "" );

    this.loggedInUserName = firstName + " " + lastName;
    this.loggedInUserEmail = (this.loggedInUser.emailId) ? this.loggedInUser.emailId : "";
  }
  
  switchSideBar(clickedLink) {
    this.activeLink = clickedLink;

    this.switchSideBarForMe.emit(this.activeLink);
  }
}
