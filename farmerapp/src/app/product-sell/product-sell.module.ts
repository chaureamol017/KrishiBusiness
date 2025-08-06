import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SellProductComponent } from './sell-product/sell-product.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../material/material.module';
import { SharedComponentsModule } from '../shared-components/shared-components.module';
import { ProductBidComponent } from './product-bid/product-bid.component';
import { AddEditFarmerProductComponent } from './add-edit-farmer-product/add-edit-farmer-product.component';



@NgModule({
  declarations: [
    SellProductComponent,
    ProductBidComponent,
    AddEditFarmerProductComponent,
  ],
  imports: [
      CommonModule,
      FormsModule,
      ReactiveFormsModule,
  
      MaterialModule,
      SharedComponentsModule,
  ],
  exports: [
    SellProductComponent,
  ],
})
export class ProductSellModule { }
