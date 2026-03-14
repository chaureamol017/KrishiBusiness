import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { BuyerReport, BidDetail } from '../../model/report.model';
import { ReportService } from '../../services/report.service';
import { SnackBarService } from '../../services/snack-bar.service';

@Component({
  selector: 'app-buyer-report',
  templateUrl: './buyer-report.component.html',
  styleUrls: ['./buyer-report.component.scss']
})
export class BuyerReportComponent implements OnInit {
  report: BuyerReport;
  isLoading = true;
  errorMessage = '';
  listData: MatTableDataSource<BidDetail>;
  displayedColumns: string[] = ['productName', 'category', 'quotedPricePerUnit', 'bidOn', 'acceptedOn', 'accepted'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  // Date range - default last 30 days
  startDate: Date;
  endDate: Date;

  // Doughnut: Accepted vs Pending bids
  doughnutLabels: string[] = ['Accepted', 'Pending'];
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

  // Bar: Quoted price per KG (normalized)
  barLabels: string[] = [];
  barData: Array<any> = [{ data: [], label: 'Quoted Price/KG (₹)' }];
  barColors = [{ backgroundColor: '#7b1fa2' }];
  barOptions: any = {
    responsive: true,
    maintainAspectRatio: false,
    scales: { yAxes: [{ ticks: { beginAtZero: true } }] },
    tooltips: {
      callbacks: {
        label: (tooltipItem) => ` ₹${Number(tooltipItem.yLabel).toFixed(2)} / KG`
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
    this.reportService.getBuyerReport(this.startDate, this.endDate).subscribe(
      response => {
        this.isLoading = false;
        if (response && response.success) {
          this.report = response.data;
          this.listData = new MatTableDataSource(this.report.bidDetails);
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
        console.error('Buyer report error:', error);
      }
    );
  }

  private normalizeToKg(price: number, unit: string): number {
    const u = (unit || '').toLowerCase();
    if (u === 'gram') return price * 1000;
    if (u === 'ton') return price / 1000;
    if (u === 'pound') return price / 0.453592;
    return price; // Kilogram or unknown
  }

  private buildCharts() {
    try {
      this.doughnutData = [this.report.totalBidsAccepted, this.report.totalBidsPending];
      const bids = this.report.bidDetails || [];
      // Exclude accepted (purchased) bids, show only pending
      const pendingBids = bids.filter(b => !b.accepted);
      const top10 = [...pendingBids].slice(0, 10);
      this.barLabels = top10.map(b => b.productName || 'Unknown');
      this.barData = [{ data: top10.map(b => Math.round(this.normalizeToKg(b.quotedPricePerUnit, b.quantityUnit) * 100) / 100), label: 'Quoted Price/KG (₹)' }];
    } catch (e) {
      console.error('Chart build error:', e);
    }
  }
}
