import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  @Output() switchSideBarForMe: EventEmitter<any> = new EventEmitter();

  activeLink: any = 0; 
  loggedInUserName: any;
  loggedInUserEmail: any;
  constructor(private adminService: AdminService) {
    adminService.onValidateCall
  }

  ngOnInit() {
    this.activeLink = 0; 
    this.loggedInUserName = this.adminService.getFirstName() + " " + this.adminService.getLastName();
    this.loggedInUserEmail = this.adminService.getEmailId();
  }
  
  switchSideBar(clickedLink) {
    this.activeLink = clickedLink;

    this.switchSideBarForMe.emit(this.activeLink);
  }
}
