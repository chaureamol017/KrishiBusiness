import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { MatIconModule, MatToolbarModule, MatButtonModule, MatMenuModule, MatDividerModule, MatSidenavModule } from '@angular/material';
import { DashboardModule } from '../dashboard/dashboard.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';


// const routes: Routes = [{
//     path: 'login',
//     component: LoginComponent
//   }];

@NgModule({
  declarations: [HomeComponent],
  imports: [
    // RouterModule.forRoot(routes, { useHash: true }),
    CommonModule,
    
    FormsModule,
    ReactiveFormsModule,

    MatButtonModule,
    MatDividerModule,
    MatIconModule,
    MatToolbarModule,
    MatSidenavModule,

    DashboardModule,
  ]
})
export class HomeModule { }
