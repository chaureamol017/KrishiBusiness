import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { BuyProductComponent } from './product-buy/buy-product/buy-product.component';
import { ProductSellComponent } from './product-sell/product-sell/product-sell.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { AuthGuard } from './guard/auth.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    // canActivate: [AuthGuard],
  }, {
    path: 'home',
    component: HomeComponent,
    // canActivate: [AuthGuard],
  }, {
    path: 'products',
    component: ProductListComponent,

    canActivate: [AuthGuard],
  }, {
    path: 'buy-products',
    component: BuyProductComponent,
    canActivate: [AuthGuard],
  }, {
    path: 'sell-products',
    component: ProductSellComponent,
    canActivate: [AuthGuard],
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
