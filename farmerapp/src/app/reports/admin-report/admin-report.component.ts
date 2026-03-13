import { Component, OnInit } from '@angular/core';
import { AdminReport } from '../../model/report.model';
import { ReportService } from '../../services/report.service';
import { SnackBarService } from '../../services/snack-bar.service';

@Component({
  selector: 'app-admin-report',
  templateUrl: './admin-report.component.html',
  styleUrls: ['./admin-report.component.scss']
})
export class AdminReportComponent implements OnInit {
  report: AdminReport;

  // Doughnut: Products sold vs unsold
  productDoughnutLabels: string[] = ['Sold', 'Unsold'];
  productDoughnutData: number[] = [0, 0];
  productDoughnutColors = [{ backgroundColor: ['#4caf50', '#ff9800'] }];
  doughnutOptions = { responsive: true, maintainAspectRatio: false };

  // Doughnut: Bids accepted vs pending
  bidDoughnutLabels: string[] = ['Accepted', 'Pending'];
  bidDoughnutData: number[] = [0, 0];
  bidDoughnutColors = [{ backgroundColor: ['#1976d2', '#e53935'] }];

  // Bar: Platform overview
  platformBarLabels: string[] = ['Users', 'Catalog Products', 'Farmer Listings', 'Sold', 'Unsold', 'Bids', 'Accepted Bids'];
  platformBarData: Array<any> = [{ data: [], label: 'Count' }];
  platformBarColors = [{ backgroundColor: ['#1976d2', '#7b1fa2', '#388e3c', '#4caf50', '#ff9800', '#f57c00', '#2196f3'] }];
  platformBarOptions = { responsive: true, maintainAspectRatio: false, scales: { yAxes: [{ ticks: { beginAtZero: true } }] } };

  constructor(
    private reportService: ReportService,
    private snackBarService: SnackBarService,
  ) {}

  ngOnInit() {
    this.loadReport();
  }

  loadReport() {
    this.reportService.getAdminReport().subscribe(
      response => {
        if (response.success) {
          this.report = response.data;
          this.buildCharts();
        }
      },
      error => this.snackBarService.notify()
    );
  }

  private buildCharts() {
    this.productDoughnutData = [this.report.totalFarmerProductsSold, this.report.totalFarmerProductsUnsold];
    this.bidDoughnutData = [this.report.totalAcceptedBids, this.report.totalBids - this.report.totalAcceptedBids];
    this.platformBarData = [{
      data: [
        this.report.totalUsers,
        this.report.totalProducts,
        this.report.totalFarmerProducts,
        this.report.totalFarmerProductsSold,
        this.report.totalFarmerProductsUnsold,
        this.report.totalBids,
        this.report.totalAcceptedBids,
      ],
      label: 'Count'
    }];
  }
}
