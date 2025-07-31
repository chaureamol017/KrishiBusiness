import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { NavLink } from 'src/app/model/nav-link';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.scss']
})
export class SideBarComponent implements OnInit {
  activeLink: any = 0;
  
  navLinks: NavLink[] = [
    { title: 'Home', icon: 'home', path: '/home' },
    { title: 'Products', icon: 'shopping_cart', path: '/products' },
    // { title: 'Profile', icon: 'person', path: '/profile' },
    { title: 'Settings', icon: 'settings', path: '/settings' }
  ];

  constructor(
    private router: Router,
  ) {
  }

  ngOnInit() {
    this.activeLink = 0;
  }
  
  onClickNavLink(navLink: NavLink, activeLink: number) {
    this.activeLink = activeLink;
    this.router.navigate([navLink.path]);
  }

}
