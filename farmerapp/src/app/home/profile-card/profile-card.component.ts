import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from '../../services/local-storage.service';

@Component({
  selector: 'app-profile-card',
  templateUrl: './profile-card.component.html',
  styleUrls: ['./profile-card.component.scss']
})
export class ProfileCardComponent implements OnInit {

  loggedInUserName: any;
  loggedInUserEmail: any;

  constructor(
    private localStorageService: LocalStorageService,
  ) {
  }


  ngOnInit() {
    this.loggedInUserName = this.localStorageService.getFirstName() + " " + this.localStorageService.getLastName();
    this.loggedInUserEmail = this.localStorageService.getEmailId();
  }

}
