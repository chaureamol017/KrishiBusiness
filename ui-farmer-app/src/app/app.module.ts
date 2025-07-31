import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ProductModule } from './product/product.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { HomeModule } from './home/home.module';
import { ChangePasswordComponent } from './dashboard/profile/change-password/change-password.component';
import { UserService } from './services/user.service';
import { HttpClientModule } from '@angular/common/http';
import { AdminService } from './services/admin.service';
import { ProfileComponent } from './dashboard/profile/profile.component';
import { DefaultModule } from './default/default.module';
import { MyLoginComponent } from './entry-components/my-login/my-login.component';
import { EntryComponentsModule } from './entry-components/entry-components.module';
import { SignUpComponent } from './entry-components/sign-up/sign-up.component';
import { ProductComponent } from './entry-components/product/product.component';
import { AddEditProductBidComponent } from './entry-components/add-edit-product-bid/add-edit-product-bid.component';
import { ProductBidComponent } from './entry-components/product-bid/product-bid.component';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,

    HttpClientModule ,
    
    EntryComponentsModule,
    DefaultModule,
    HomeModule,
    DashboardModule,
    ProductModule,
  ],
  entryComponents: [
    MyLoginComponent,
    SignUpComponent,

    ProfileComponent,
    ChangePasswordComponent,

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
