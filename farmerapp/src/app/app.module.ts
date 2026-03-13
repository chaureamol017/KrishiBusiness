import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProductModule } from './product/product.module';
import { HomeModule } from './home/home.module';
import { MaterialModule } from './material/material.module';
import { LocalStorageService } from './services/local-storage.service';
import { ProductBuyModule } from './product-buy/product-buy.module';
import { ProductSellModule } from './product-sell/product-sell.module';
import { ReportsModule } from './reports/reports.module';
import { ChartsModule, ThemeService } from 'ng2-charts';

@NgModule({
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,

    MaterialModule,
    ChartsModule,

    HomeModule,
    ProductModule,
    ProductBuyModule,
    ProductSellModule,
    ReportsModule,
  ],
  entryComponents: [
  ],
  providers: [
    LocalStorageService,
    ThemeService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
