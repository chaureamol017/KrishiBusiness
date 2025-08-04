import { Component, OnInit, } from '@angular/core';
import { Router } from '@angular/router';
import { NavLink } from 'src/app/model/nav-link';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  home: NavLink = { title: 'Home', icon: 'home', path: '/home' };
  products: NavLink = { title: 'Products', icon: 'shopping_cart', path: '/products' };
  sellProducts: NavLink = { title: 'Sell Products', icon: 'shopping_cart', path: '/sell-products' };
  buyProducts: NavLink = { title: 'Buy Products', icon: 'shopping_cart', path: '/buy-products' };
  settings: NavLink = { title: 'Settings', icon: 'settings', path: '/settings' };
  
  allNavLinks: NavLink[] = [this.home, this.products, this.sellProducts, this.buyProducts, this.settings];
  navLinks: NavLink[] = [];

  constructor(
    private adminService: AdminService,
    private router: Router,
  ) {
    adminService.onValidateCall
  }

  ngOnInit() {
    const userRole = this.adminService.getRole();
    this.filterNavlinks(userRole);
  }

  private filterNavlinks(userRole: string) {
    if (userRole === 'admin') {
      this.navLinks = this.allNavLinks.filter(link => link.role === 'admin' || !link.role);
    } else if (userRole === 'user') {
      this.navLinks = this.allNavLinks.filter(link => link.role === 'user' || !link.role);
    } else if (userRole === 'buyer') {
      this.navLinks = this.allNavLinks.filter(link => link.role === 'buyer' || !link.role);
    } else {
      this.navLinks = this.allNavLinks.filter(link => !link.role);
    }
  }

  isActiveLink(navLink: NavLink) {
    return this.router.isActive(navLink.path, true);
  }

  onClickNavLink(navLink: NavLink) {
    this.router.navigate([navLink.path]);
  }
}
