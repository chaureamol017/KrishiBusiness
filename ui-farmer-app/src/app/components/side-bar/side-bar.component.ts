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
  
  allNavLinks: NavLink[] = [
    { title: 'Home', icon: 'home', path: '/home' },
    { title: 'Products', icon: 'shopping_cart', path: '/products' },
    // { title: 'Profile', icon: 'person', path: '/profile' },
    { title: 'Settings', icon: 'settings', path: '/settings' }
  ];
  navLinks: NavLink[] = [];

  constructor(
    private router: Router,
  ) {
  }

  ngOnInit() {
    const userRole = localStorage.getItem("role");
    if (userRole === 'admin') {
      this.navLinks = this.allNavLinks.filter(link => link.role === 'admin' || !link.role);
    } else if (userRole === 'user') {
      this.navLinks = this.allNavLinks.filter(link => link.role === 'user' || !link.role);
    } else {
      this.navLinks = this.allNavLinks.filter(link => !link.role);
    }
    this.activeLink = 0;
  }
  
  onClickNavLink(navLink: NavLink, activeLink: number) {
    this.activeLink = activeLink;
    this.router.navigate([navLink.path]);
  }

}
