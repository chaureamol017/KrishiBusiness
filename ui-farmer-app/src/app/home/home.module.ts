import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { MatIconModule, MatToolbarModule, MatButtonModule, MatMenuModule, MatDividerModule, MatSidenavModule } from '@angular/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { BannerComponent } from './banner/banner.component';
import { CardBannerComponent } from './card-banner/card-banner.component';


// const routes: Routes = [{
//     path: 'login',
//     component: LoginComponent
//   }];

@NgModule({
  declarations: [
    HomeComponent,
    LoginComponent,
    BannerComponent,
    CardBannerComponent,
  ],
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

  ]
})
export class HomeModule { }
