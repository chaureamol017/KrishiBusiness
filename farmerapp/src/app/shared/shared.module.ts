import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TopBarComponent } from './top-bar/top-bar.component';
import { TopDialogContentComponent } from './top-dialog-content/top-dialog-content.component';
import { MaterialModule } from '../material/material.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { TableCellActionComponent } from './table-cell-action/table-cell-action.component';
import { BannerComponent } from './banner/banner.component';
import { BannerCardComponent } from './banner-card/banner-card.component';



@NgModule({
  declarations: [
    TopBarComponent,
    TopDialogContentComponent,
    TableCellActionComponent,
    BannerComponent,
    BannerCardComponent,
  ],
  imports: [
    CommonModule,
    FlexLayoutModule,

    MaterialModule,
  ],
  exports: [
    TopBarComponent,
    TopDialogContentComponent,
    TableCellActionComponent,
    BannerComponent,
    BannerCardComponent,
  ]
})
export class SharedModule { }
