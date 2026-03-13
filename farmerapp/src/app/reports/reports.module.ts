import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../material/material.module';
import { SharedModule } from '../shared/shared.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ReportsComponent } from './reports/reports.component';
import { SellerReportComponent } from './seller-report/seller-report.component';
import { BuyerReportComponent } from './buyer-report/buyer-report.component';
import { AdminReportComponent } from './admin-report/admin-report.component';

@NgModule({
  declarations: [
    ReportsComponent,
    SellerReportComponent,
    BuyerReportComponent,
    AdminReportComponent,
  ],
  imports: [
    CommonModule,
    FlexLayoutModule,
    MaterialModule,
    SharedModule,
  ],
  exports: [
    ReportsComponent,
  ]
})
export class ReportsModule { }
