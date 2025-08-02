import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Router } from '@angular/router';
import { NavLink } from 'src/app/model/nav-link';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  @Output() switchSideBarForMe: EventEmitter<any> = new EventEmitter();
  activeLink: any = 0; 

  allNavLinks: NavLink[] = [
    { title: 'Home', icon: 'home', path: '/home' },
    { title: 'Products', icon: 'shopping_cart', path: '/products' },
    { title: 'Sell Products', icon: 'shopping_cart', path: '/sell-products' },
    { title: 'Settings', icon: 'settings', path: '/settings' }
  ];
  navLinks: NavLink[] = [];

  constructor(
    private adminService: AdminService,
    private router: Router,
  ) {
    adminService.onValidateCall
  }

  ngOnInit() {
    this.activeLink = 0;


    const userRole = this.adminService.getRole();
    if (userRole === 'admin') {
      this.navLinks = this.allNavLinks.filter(link => link.role === 'admin' || !link.role);
    } else if (userRole === 'user') {
      this.navLinks = this.allNavLinks.filter(link => link.role === 'user' || !link.role);
    } else {
      this.navLinks = this.allNavLinks.filter(link => !link.role);
    }
  }


  onClickNavLink(navLink: NavLink, activeLink: number) {
    this.activeLink = activeLink;
    this.router.navigate([navLink.path]);
  }

  switchSideBar(clickedLink) {
    this.activeLink = clickedLink;

    this.switchSideBarForMe.emit(this.activeLink);
  }
}
