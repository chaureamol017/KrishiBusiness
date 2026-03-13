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
        }
      },
      error => this.snackBarService.notify()
    );
  }
}
