import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DefaultModule } from './default/default.module';
import { EntryComponentsModule } from './entry-components/entry-components.module';
import { ProductComponent } from './entry-components/product/product.component';
import { ProductModule } from './product/product.module';
import { HomeModule } from './home/home.module';
import { MaterialModule } from './material/material.module';
import { AuthService } from './services/auth.service';
import { UserService } from './services/user.service';
import { ProductBuyModule } from './product-buy/product-buy.module';
import { ProductSellModule } from './product-sell/product-sell.module';

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

    EntryComponentsModule,
    DefaultModule,
    HomeModule,
    ProductModule,
    ProductBuyModule,
    ProductSellModule,
  ],
  entryComponents: [

    ProductComponent,
  ],
  providers: [
    UserService,
    AuthService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
