import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from '../../services/local-storage.service';
import { DashboardService, DashboardData } from '../../services/dashboard.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  appName: any = "Krishi Business";
  isLoggedIn = false;
  userRole = '';
  firstName = '';
  dashboardData: DashboardData = null;
  isLoading = false;
  errorMessage = '';

  isSeller = false;
  isBuyer = false;
  isAdmin = false;

  constructor(
    private localStorageService: LocalStorageService,
    private dashboardService: DashboardService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.isLoggedIn = this.localStorageService.isLoggedIn();
    this.userRole = this.localStorageService.getRole();
    this.firstName = this.localStorageService.getFirstName();

    if (this.isLoggedIn) {
      const role = this.userRole ? this.userRole.toUpperCase() : '';
      this.isAdmin = role === 'ADMIN';
      this.isSeller = role === 'SELLER' || role === 'BOTH' || role === 'ADMIN';
      this.isBuyer = role === 'BUYER' || role === 'BOTH' || role === 'ADMIN';
      this.loadDashboard();
    }
  }

  loadDashboard() {
    this.isLoading = true;
    this.dashboardService.getDashboard().subscribe(
      response => {
        this.isLoading = false;
        if (response && response.success) {
          this.dashboardData = response.data;
        }
      },
      error => {
        this.isLoading = false;
        this.errorMessage = 'Failed to load dashboard data.';
      }
    );
  }

  navigateTo(path: string) {
    this.router.navigate([path]);
  }
}
