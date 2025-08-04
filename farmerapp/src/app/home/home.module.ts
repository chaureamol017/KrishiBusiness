import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MaterialModule } from '../material/material.module';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ChangePasswordComponent } from './profile/change-password/change-password.component';
import { UserDetailsComponent } from './profile/user-details/user-details.component';
import { AddressDetailsComponent } from './profile/address-details/address-details.component';
import { BankDetailsComponent } from './profile/bank-details/bank-details.component';
import { ProfileComponent } from './profile/profile.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ProfileCardComponent } from './profile-card/profile-card.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { SharedComponentsModule } from '../shared-components/shared-components.module';

@NgModule({
  declarations: [
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    AddressDetailsComponent,
    BankDetailsComponent,
    ChangePasswordComponent,
    ProfileComponent,
    UserDetailsComponent,
    SidebarComponent,
    ProfileCardComponent,
    
    LoginComponent,
    SignUpComponent,
  ],
  imports: [
    // RouterModule.forRoot(routes, { useHash: true }),
    CommonModule,
    FormsModule,
    ReactiveFormsModule,

    FlexLayoutModule,

    // MatButtonModule,
    // MatDividerModule,
    // MatIconModule,
    // MatToolbarModule,
    // MatSidenavModule,
    MaterialModule,
    SharedComponentsModule,

    // DashboardModule,
  ],
  exports: [
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    AddressDetailsComponent,
    BankDetailsComponent,
    ChangePasswordComponent,
    ProfileComponent,
    UserDetailsComponent,
    SidebarComponent,
  ],
  entryComponents: [
    LoginComponent,
    SignUpComponent,
    ProfileComponent,
    ChangePasswordComponent,
  ]
})
export class HomeModule { }
