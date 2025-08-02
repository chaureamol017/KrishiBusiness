import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DefaultComponent } from './default/default/default.component';
import { HomeComponent } from './home/home/home.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { SellingProductsListComponent } from './product/selling-products-list/selling-products-list.component';
// import { LoginComponent } from './default/login/login.component';



const routes: Routes = [
  {
    path: '',
    component: DefaultComponent,
  }, {
    path: 'home',
    component: HomeComponent
  }, {
    path: 'products',
    component: ProductListComponent,
  }, {
    path: 'sell-products',
    component: SellingProductsListComponent,
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
