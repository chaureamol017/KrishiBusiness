import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { BuyProductComponent } from './product-buy/buy-product/buy-product.component';
import { ProductSellComponent } from './product-sell/product-sell/product-sell.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ReportsComponent } from './reports/reports/reports.component';
import { TransactionHistoryComponent } from './transactions/transaction-history/transaction-history.component';
import { UserManagementComponent } from './user-management/user-management/user-management.component';
import { CategoryAnalyticsComponent } from './category-analytics/category-analytics/category-analytics.component';
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
  }, {
    path: 'reports',
    component: ReportsComponent,
    canActivate: [AuthGuard],
  }, {
    path: 'transactions',
    component: TransactionHistoryComponent,
    canActivate: [AuthGuard],
  }, {
    path: 'user-management',
    component: UserManagementComponent,
    canActivate: [AuthGuard],
  }, {
    path: 'category-analytics',
    component: CategoryAnalyticsComponent,
    canActivate: [AuthGuard],
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
