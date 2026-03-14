import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from '../../services/local-storage.service';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.scss'],
  host: {
    'class': 'flex-column-stretch-gap',
  }
})
export class ReportsComponent implements OnInit {
  userRole: string;
  showSellerReport = false;
  showBuyerReport = false;
  showAdminReport = false;

  constructor(private localStorageService: LocalStorageService) {}

  ngOnInit() {
    this.userRole = this.localStorageService.getRole();
    const role = this.userRole ? this.userRole.toUpperCase() : '';

    if (role === 'ADMIN') {
      this.showAdminReport = true;
      this.showSellerReport = true;
      this.showBuyerReport = true;
    } else if (role === 'BOTH' || role === 'SELLER') {
      // Sellers can also buy, so show both reports
      this.showSellerReport = true;
      this.showBuyerReport = true;
    } else if (role === 'BUYER') {
      this.showBuyerReport = true;
    }
  }
}
