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
  errorMessage = '';
  listData: MatTableDataSource<ProductSalesDetail>;
  displayedColumns: string[] = ['productName', 'category', 'quantity', 'pricePerUnit', 'city', 'addedOn', 'soldOn', 'sold', 'totalValue'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  // Date range - default last 30 days
  startDate: Date;
  endDate: Date;

  // Doughnut: Sold vs Unsold
  doughnutLabels: string[] = ['Sold', 'Unsold'];
  doughnutData: number[] = [0, 0];
  doughnutColors = [{ backgroundColor: ['#4caf50', '#ff9800'] }];
  doughnutOptions: any = {
    responsive: true,
    maintainAspectRatio: false,
    tooltips: {
      callbacks: {
        label: (tooltipItem, data) => {
          const dataset = data.datasets[tooltipItem.datasetIndex];
          const total = dataset.data.reduce((sum, val) => sum + val, 0);
          const value = dataset.data[tooltipItem.index];
          const pct = total > 0 ? ((value / total) * 100).toFixed(1) : '0';
          const label = data.labels[tooltipItem.index];
          return ` ${label}: ${value} (${pct}%)`;
        }
      }
    }
  };

  // Bar: Revenue per product (percentage)
  barLabels: string[] = [];
  barData: Array<any> = [{ data: [], label: 'Revenue Share (%)' }];
  barColors = [{ backgroundColor: '#1976d2' }];
  barOptions: any = {
    responsive: true,
    maintainAspectRatio: false,
    scales: { yAxes: [{ ticks: { beginAtZero: true, max: 100 } }] },
    tooltips: {
      callbacks: {
        label: (tooltipItem, data) => {
          const pct = Number(tooltipItem.yLabel).toFixed(1);
          const idx = tooltipItem.index;
          const amount = data.datasets[0]._amounts ? data.datasets[0]._amounts[idx] : '';
          return amount ? ` ₹${amount.toFixed(2)} (${pct}%)` : ` ${pct}%`;
        }
      }
    }
  };

  constructor(
    private reportService: ReportService,
    private snackBarService: SnackBarService,
  ) {}

  ngOnInit() {
    const now = new Date();
    this.endDate = new Date(now);
    this.startDate = new Date(now.setDate(now.getDate() - 30));
    this.loadReport();
  }

  loadReport() {
    this.isLoading = true;
    this.errorMessage = '';
    this.reportService.getSellerReport(this.startDate, this.endDate).subscribe(
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
    try {
      this.doughnutData = [this.report.totalProductsSold, this.report.totalProductsUnsold];
      const details = this.report.productSalesDetails || [];
      const top10 = [...details]
        .sort((a, b) => b.totalValue - a.totalValue)
        .slice(0, 10);
      const totalRevenue = details.reduce((sum, p) => sum + p.totalValue, 0);
      const amounts = top10.map(p => p.totalValue);
      const percentages = top10.map(p => totalRevenue > 0 ? Math.round((p.totalValue / totalRevenue) * 1000) / 10 : 0);
      this.barLabels = top10.map(p => p.productName || 'Unknown');
      this.barData = [{ data: percentages, label: 'Revenue Share (%)', _amounts: amounts }];
    } catch (e) {
      console.error('Chart build error:', e);
    }
  }
}
