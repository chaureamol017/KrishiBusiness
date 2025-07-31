import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ProductModule } from './product/product.module';
import { HomeModule } from './home/home.module';
import { UserService } from './services/user.service';
import { HttpClientModule } from '@angular/common/http';
import { AdminService } from './services/admin.service';
import { DefaultModule } from './default/default.module';
import { MyLoginComponent } from './entry-components/my-login/my-login.component';
import { EntryComponentsModule } from './entry-components/entry-components.module';
import { SignUpComponent } from './entry-components/sign-up/sign-up.component';
import { ProductComponent } from './entry-components/product/product.component';
import { AddEditProductBidComponent } from './entry-components/add-edit-product-bid/add-edit-product-bid.component';
import { ProductBidComponent } from './entry-components/product-bid/product-bid.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { SideBarComponent } from './components/side-bar/side-bar.component';



import { MatButtonModule, MatDividerModule, MatToolbarModule, MatIconModule, MatMenuModule, MatListModule, MatSidenavModule, MatDialogModule } from '@angular/material'
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProfileCardComponent } from './components/profile-card/profile-card.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SideBarComponent,
    ProfileCardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,

    CommonModule,

    FormsModule,
    ReactiveFormsModule,
    
    MatButtonModule,
    MatDividerModule,
    MatDialogModule,
    MatIconModule,
    MatListModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,

    HttpClientModule ,
    
    EntryComponentsModule,
    DefaultModule,
    HomeModule,
    ProductModule,
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
