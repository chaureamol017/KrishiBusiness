import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../material/material.module';
import { SharedModule } from '../shared/shared.module';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';

@NgModule({
  declarations: [
    TransactionHistoryComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    SharedModule,
  ],
  exports: [
    TransactionHistoryComponent,
  ]
})
export class TransactionsModule { }
