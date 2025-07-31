import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DefaultComponent } from './default/default/default.component';
import { HomeComponent } from './home/home/home.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { AuthGuard } from './guard/auth.guard';
// import { LoginComponent } from './default/login/login.component';



const routes: Routes = [
  {
    path: '',
    component: DefaultComponent,
  }, {
    path: 'home',
    component: HomeComponent,
    canActivate: [AuthGuard],
  }, {
    path: 'products',
    component: ProductListComponent
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
