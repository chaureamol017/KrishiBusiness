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
  listData: MatTableDataSource<BidDetail>;
  displayedColumns: string[] = ['productName', 'category', 'quotedPricePerUnit', 'bidOn', 'acceptedOn', 'accepted'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  constructor(
    private reportService: ReportService,
    private snackBarService: SnackBarService,
  ) {}

  ngOnInit() {
    this.loadReport();
  }

  loadReport() {
    this.reportService.getBuyerReport().subscribe(
      response => {
        if (response.success) {
          this.report = response.data;
          this.listData = new MatTableDataSource(this.report.bidDetails);
          this.listData.sort = this.sort;
          this.listData.paginator = this.paginator;
        }
      },
      error => this.snackBarService.notify()
    );
  }
}
