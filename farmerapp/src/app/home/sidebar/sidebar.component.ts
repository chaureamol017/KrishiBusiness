import { Component, OnInit, } from '@angular/core';
import { Router } from '@angular/router';
import { NavLink } from '../../model/nav-link';
import { LocalStorageService } from '../../services/local-storage.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  home: NavLink = { title: 'Home', icon: 'home', path: '/home', role: ['*'] };
  products: NavLink = { title: 'Products', icon: 'business', path: '/products', role: ['*'] };
  sellProducts: NavLink = { title: 'Sell Products', icon: 'shop', path: '/sell-products', role: ['SELLER'] };
  buyProducts: NavLink = { title: 'Buy Products', icon: 'store', path: '/buy-products', role: ['*'] };
  reports: NavLink = { title: 'Reports', icon: 'assessment', path: '/reports', role: ['*'] };
  settings: NavLink = { title: 'Settings', icon: 'settings', path: '/settings', role: ['ADMIN'] };
  
  allNavLinks: NavLink[] = [this.home, this.products, this.sellProducts, this.buyProducts, this.reports, this.settings];
  navLinks: NavLink[] = [];

  constructor(
    private localStorageService: LocalStorageService,
    private router: Router,
  ) {
  }

  ngOnInit() {
    const userRole = this.localStorageService.getRole();
    this.navLinks = this.allNavLinks.filter((navLink) => this.filterNavlinks(navLink, userRole));
  }

  private filterNavlinks(link: NavLink, userRole: string): boolean {
    if (!link.role || (link.role && (link.role[0] == '*' || link.role[0] == userRole))) {
      return true;
    } else {
      return false;
    }

  }

  isActiveLink(navLink: NavLink) {
    return this.router.isActive(navLink.path, true);
  }

  onClickNavLink(navLink: NavLink) {
    this.router.navigate([navLink.path]);
  }
}
