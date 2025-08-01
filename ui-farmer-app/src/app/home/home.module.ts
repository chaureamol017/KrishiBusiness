import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FlexLayoutModule } from '@angular/flex-layout';
import { HomeComponent } from './home/home.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { BannerComponent } from './banner/banner.component';
import { CardBannerComponent } from './card-banner/card-banner.component';
import { MaterialModule } from '../material/material.module';


@NgModule({
  declarations: [
    HomeComponent,
    BannerComponent,
    CardBannerComponent,
  ],
  imports: [
    CommonModule,    
    FormsModule,
    ReactiveFormsModule,

    MaterialModule,

    FlexLayoutModule,
  ]
})
export class HomeModule { }
