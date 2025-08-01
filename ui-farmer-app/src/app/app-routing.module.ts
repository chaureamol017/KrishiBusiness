import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { AuthGuard } from './guard/auth.guard';
import { ProductComponent } from './product/product/product.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { LoginComponent } from './auth/login/login.component';
// import { LoginComponent } from './default/login/login.component';



const routes: Routes = [
  {
    path: '',
    // component: DefaultComponent,
    component: HomeComponent,
  }, {
    path: 'login',
    component: LoginComponent
  }, {
    path: 'sign-up',
    component: SignUpComponent
  }, {
    path: 'home',
    component: HomeComponent,
    canActivate: [AuthGuard],
  }, {
    path: 'products',
    component: ProductComponent
  }];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule,
  ]
})
export class AppRoutingModule { }
