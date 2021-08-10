import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.scss']
})
export class MainpageComponent implements OnInit {
  sideBarOpen = true;
  sideBarIndex = 0;
  constructor(
  ) {
    
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
