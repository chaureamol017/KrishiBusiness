import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HomeModule } from './home/home.module';
import { UserService } from './services/user.service';
import { HttpClientModule } from '@angular/common/http';
import { AdminService } from './services/admin.service';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { SideBarComponent } from './components/side-bar/side-bar.component';



import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProfileCardComponent } from './components/profile-card/profile-card.component';
import { AuthService } from './services/auth.service';
import { MaterialModule } from './material/material.module';
import { LocalComponent } from './components/local/local.component';
import { FlexModule } from '@angular/flex-layout';
import { LoginComponent } from './auth/login/login.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { TopDialogContentComponent } from './common/top-dialog-content/top-dialog-content.component';

@NgModule({
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  declarations: [
    TopDialogContentComponent,

    AppComponent,
    HeaderComponent,
    FooterComponent,
    SideBarComponent,
    ProfileCardComponent,

    LoginComponent,
    SignUpComponent,

    LocalComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,

    FormsModule,
    ReactiveFormsModule,

    FlexModule,

    MaterialModule,
    HomeModule,
  ],
  entryComponents: [
    
  ],
  providers: [
    UserService,
    AdminService,
    AuthService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
