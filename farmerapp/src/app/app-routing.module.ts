import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DefaultComponent } from './default/default/default.component';
import { HomeComponent } from './home/home/home.component';
import { BuyProductComponent } from './product-buy/buy-product/buy-product.component';
import { SellProductComponent } from './product-sell/sell-product/sell-product.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { AuthGuard } from './guard/auth.guard';

const routes: Routes = [
  {
    path: '',
    component: DefaultComponent,
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
    component: SellProductComponent,
    canActivate: [AuthGuard],
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
