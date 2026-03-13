import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { SellerReport, ProductSalesDetail } from '../../model/report.model';
import { ReportService } from '../../services/report.service';
import { SnackBarService } from '../../services/snack-bar.service';

@Component({
  selector: 'app-seller-report',
  templateUrl: './seller-report.component.html',
  styleUrls: ['./seller-report.component.scss']
})
export class SellerReportComponent implements OnInit {
  report: SellerReport;
  isLoading = true;
  errorMessage: string;
  listData: MatTableDataSource<ProductSalesDetail>;
  displayedColumns: string[] = ['productName', 'category', 'quantity', 'pricePerUnit', 'city', 'addedOn', 'soldOn', 'sold', 'totalValue'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  // Doughnut: Sold vs Unsold
  doughnutLabels: string[] = ['Sold', 'Unsold'];
  doughnutData: number[] = [0, 0];
  doughnutColors = [{ backgroundColor: ['#4caf50', '#ff9800'] }];
  doughnutOptions = { responsive: true, maintainAspectRatio: false };

  // Bar: Revenue per product
  barLabels: string[] = [];
  barData: Array<any> = [{ data: [], label: 'Total Value (₹)' }];
  barColors = [{ backgroundColor: '#1976d2' }];
  barOptions = { responsive: true, maintainAspectRatio: false, scales: { yAxes: [{ ticks: { beginAtZero: true } }] } };

  constructor(
    private reportService: ReportService,
    private snackBarService: SnackBarService,
  ) {}

  ngOnInit() {
    this.loadReport();
  }

  loadReport() {
    this.isLoading = true;
    this.errorMessage = null;
    this.reportService.getSellerReport().subscribe(
      response => {
        this.isLoading = false;
        if (response && response.success) {
          this.report = response.data;
          this.listData = new MatTableDataSource(this.report.productSalesDetails);
          this.listData.sort = this.sort;
          this.listData.paginator = this.paginator;
          this.buildCharts();
        } else {
          this.errorMessage = (response && response.message) ? response.message.toString() : 'Failed to load report.';
        }
      },
      error => {
        this.isLoading = false;
        this.errorMessage = 'Could not connect to server. Please ensure the backend is running.';
        console.error('Seller report error:', error);
      }
    );
  }

  private buildCharts() {
    this.doughnutData = [this.report.totalProductsSold, this.report.totalProductsUnsold];

    const top10 = [...this.report.productSalesDetails]
      .sort((a, b) => b.totalValue - a.totalValue)
      .slice(0, 10);
    this.barLabels = top10.map(p => p.productName || 'Unknown');
    this.barData = [{ data: top10.map(p => p.totalValue), label: 'Total Value (₹)' }];
  }
}
