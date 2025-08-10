import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductSellComponent } from './product-sell/product-sell.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../material/material.module';
import { SharedModule } from '../shared/shared.module';
import { ProductBidComponent } from './product-bid/product-bid.component';
import { AddEditFarmerProductComponent } from './add-edit-farmer-product/add-edit-farmer-product.component';



@NgModule({
  declarations: [
    ProductSellComponent,
    ProductBidComponent,
    AddEditFarmerProductComponent,
  ],
  imports: [
      CommonModule,
      FormsModule,
      ReactiveFormsModule,
  
      MaterialModule,
      SharedModule,
  ],
  exports: [
    ProductSellComponent,
  ],
  entryComponents: [
    AddEditFarmerProductComponent,
    ProductBidComponent,
  ]
})
export class ProductSellModule { }
