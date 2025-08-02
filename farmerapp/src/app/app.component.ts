import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'farmerapp';

  sideBarOpen = false;

  constructor(
  ) {
  }

  ngOnInit() {
    
  }

  sideBarToggler($event) {
    this.sideBarOpen = $event;
  }
}
