import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DefaultModule } from './default/default.module';
import { AddEditProductBidComponent } from './entry-components/add-edit-product-bid/add-edit-product-bid.component';
import { EntryComponentsModule } from './entry-components/entry-components.module';
import { MyLoginComponent } from './entry-components/my-login/my-login.component';
import { ProductBidComponent } from './entry-components/product-bid/product-bid.component';
import { ProductComponent } from './entry-components/product/product.component';
import { SignUpComponent } from './entry-components/sign-up/sign-up.component';
import { ProductModule } from './product/product.module';
import { HomeModule } from './home/home.module';
import { MaterialModule } from './material/material.module';
import { AdminService } from './services/admin.service';
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
    HttpClientModule ,

    MaterialModule,
    
    EntryComponentsModule,
    DefaultModule,
    HomeModule,
    ProductModule,
    ProductBuyModule,
    ProductSellModule,
  ],
  entryComponents: [
    MyLoginComponent,
    SignUpComponent,

    ProductComponent,
    AddEditProductBidComponent,
    ProductBidComponent,
  ],
  providers: [
    UserService,
    AdminService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
