import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DefaultComponent } from './default/default/default.component';
import { HomeComponent } from './home/home/home.component';
import { BuyProductComponent } from './product-buy/buy-product/buy-product.component';
import { SellProductComponent } from './product-sell/sell-product/sell-product.component';
import { ProductListComponent } from './product/product-list/product-list.component';

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
    path: 'buy-products',
    component: BuyProductComponent,
  }, {
    path: 'sell-products',
    component: SellProductComponent,
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
