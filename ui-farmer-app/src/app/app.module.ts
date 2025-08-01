import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

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

    MaterialModule,
    
    HttpClientModule ,
    
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
