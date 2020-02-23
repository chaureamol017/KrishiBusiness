import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
// import { FlexLayoutModule } from '@angular/flex-layout';
import { MatButtonModule, MatDividerModule, MatToolbarModule, MatIconModule, MatMenuModule, MatListModule, MatSidenavModule, MatDialogModule } from '@angular/material'

import { ProductModule } from '../product/product.module';
import { MainpageComponent } from './mainpage/mainpage.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ActionsModule } from '../actions/actions.module';
import { ChangePasswordComponent } from './profile/change-password/change-password.component';
import { UserDetailsComponent } from './profile/user-details/user-details.component';
import { AddressDetailsComponent } from './profile/address-details/address-details.component';
import { BankDetailsComponent } from './profile/bank-details/bank-details.component';
import { ProfileComponent } from './profile/profile.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    MainpageComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    DashboardComponent,
    ChangePasswordComponent,
    UserDetailsComponent,
    AddressDetailsComponent,
    BankDetailsComponent,
    ProfileComponent,
  ],
  imports: [
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

    ProductModule,
    ActionsModule
  ],

  exports: [
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
  ]
})
export class DashboardModule { }
