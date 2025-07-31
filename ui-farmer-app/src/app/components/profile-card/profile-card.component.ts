import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-profile-card',
  templateUrl: './profile-card.component.html',
  styleUrls: ['./profile-card.component.scss']
})
export class ProfileCardComponent implements OnInit {
  loggedInUserName: any;
  loggedInUserEmail: any;

  constructor(
    private adminService: AdminService,
  ) {
    adminService.onValidateCall
  }


  ngOnInit() {
    this.loggedInUserName = this.adminService.getFirstName() + " " + this.adminService.getLastName();
    this.loggedInUserEmail = this.adminService.getEmailId();
  }

}
