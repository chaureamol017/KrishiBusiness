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
  errorMessage: string;
  listData: MatTableDataSource<BidDetail>;
  displayedColumns: string[] = ['productName', 'category', 'quotedPricePerUnit', 'bidOn', 'acceptedOn', 'accepted'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  // Doughnut: Accepted vs Pending bids
  doughnutLabels: string[] = ['Accepted', 'Pending'];
  doughnutData: number[] = [0, 0];
  doughnutColors = [{ backgroundColor: ['#4caf50', '#ff9800'] }];
  doughnutOptions = { responsive: true, maintainAspectRatio: false };

  // Bar: Quoted price per product
  barLabels: string[] = [];
  barData: Array<any> = [{ data: [], label: 'Quoted Price/Unit (₹)' }];
  barColors = [{ backgroundColor: '#7b1fa2' }];
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
    this.reportService.getBuyerReport().subscribe(
      response => {
        this.isLoading = false;
        if (response && response.success) {
          this.report = response.data;
          this.listData = new MatTableDataSource(this.report.bidDetails);
          this.listData.sort = this.sort;
          this.listData.paginator = this.paginator;
          this.buildCharts();
        } else {
          this.errorMessage = (response && response.message) ? response.message : 'Failed to load report.';
        }
      },
      error => {
        this.isLoading = false;
        this.errorMessage = 'Could not connect to server. Please ensure the backend is running.';
        console.error('Buyer report error:', error);
      }
    );
  }

  private buildCharts() {
    this.doughnutData = [this.report.totalBidsAccepted, this.report.totalBidsPending];

    const top10 = [...this.report.bidDetails].slice(0, 10);
    this.barLabels = top10.map(b => b.productName || 'Unknown');
    this.barData = [{ data: top10.map(b => b.quotedPricePerUnit), label: 'Quoted Price/Unit (₹)' }];
  }
}
