import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  appName: string = "Krishi Business";
  isLoggedIn: boolean = false;
  userName: string = "John Doe";
  isSidebarVisible: boolean = false;

  @Output() onToggle: EventEmitter<boolean> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  login() {
    this.isLoggedIn = true;
  }

  signUp() {
    // Add sign-up logic here
  }

  logout() {
    // Add logout logic here
    this.isLoggedIn = false;
  }

  toggleSidebar() {
    this.isSidebarVisible = !this.isSidebarVisible;
    this.onToggle.emit(this.isSidebarVisible);
  }

}
