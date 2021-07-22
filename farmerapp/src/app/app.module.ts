import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ProductModule } from './product/product.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { HomeModule } from './home/home.module';
import { ProductComponent } from './product/product/product.component';
import { AddbidComponent } from './product/bidproduct/addbid/addbid.component';
import { BidlistComponent } from './product/bidproduct/bidlist/bidlist.component';
import { ChangePasswordComponent } from './dashboard/profile/change-password/change-password.component';
import { UserService } from './services/user.service';
import { HttpClientModule } from '@angular/common/http';
import { AdminService } from './services/admin.service';
import { ProfileComponent } from './dashboard/profile/profile.component';
import { DefaultModule } from './default/default.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,

    HttpClientModule ,
    
    DefaultModule,
    HomeModule,
    DashboardModule,
    ProductModule,
  ],
  entryComponents: [
    ProfileComponent,
    ChangePasswordComponent,
    ProductComponent,
    AddbidComponent,
    BidlistComponent,
  ],
  providers: [
    UserService,
    AdminService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
