import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-profile-card',
  templateUrl: './profile-card.component.html',
  styleUrls: ['./profile-card.component.scss']
})
export class ProfileCardComponent implements OnInit {

  loggedInUserName: any;
  loggedInUserEmail: any;

  constructor(
    private authService: AuthService,
  ) {
  }


  ngOnInit() {
    this.loggedInUserName = this.authService.getFirstName() + " " + this.authService.getLastName();
    this.loggedInUserEmail = this.authService.getEmailId();
  }

}
