import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { MatIconModule, MatToolbarModule, MatButtonModule, MatMenuModule } from '@angular/material';
import { DashboardModule } from '../dashboard/dashboard.module';
import { SignupComponent } from './signup/signup.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';


const routes: Routes = [{
    path: 'login',
    component: LoginComponent
  }];

@NgModule({
  declarations: [HomeComponent, LoginComponent, SignupComponent],
  imports: [
    RouterModule.forRoot(routes, { useHash: true }),
    CommonModule,
    
    FormsModule,
    ReactiveFormsModule,
    
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    DashboardModule
  ]
})
export class HomeModule { }
