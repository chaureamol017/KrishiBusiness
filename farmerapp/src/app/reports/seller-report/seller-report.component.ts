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
  listData: MatTableDataSource<ProductSalesDetail>;
  displayedColumns: string[] = ['productName', 'category', 'quantity', 'pricePerUnit', 'city', 'addedOn', 'soldOn', 'sold', 'totalValue'];
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
    this.reportService.getSellerReport().subscribe(
      response => {
        if (response.success) {
          this.report = response.data;
          this.listData = new MatTableDataSource(this.report.productSalesDetails);
          this.listData.sort = this.sort;
          this.listData.paginator = this.paginator;
        }
      },
      error => this.snackBarService.notify()
    );
  }
}
