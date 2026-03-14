import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../material/material.module';
import { SharedModule } from '../shared/shared.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ChartsModule } from 'ng2-charts';
import { CategoryAnalyticsComponent } from './category-analytics/category-analytics.component';

@NgModule({
  declarations: [
    CategoryAnalyticsComponent,
  ],
  imports: [
    CommonModule,
    FlexLayoutModule,
    MaterialModule,
    SharedModule,
    ChartsModule,
  ],
  exports: [
    CategoryAnalyticsComponent,
  ]
})
export class CategoryAnalyticsModule { }
