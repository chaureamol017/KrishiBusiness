import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BuyProductComponent } from './buy-product/buy-product.component';
import { SharedComponentsModule } from '../shared-components/shared-components.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../material/material.module';
import { AddEditProductBidComponent } from './add-edit-product-bid/add-edit-product-bid.component';



@NgModule({
  declarations: [
    AddEditProductBidComponent,
    BuyProductComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,

    MaterialModule,
    SharedComponentsModule,
  ],
  exports: [
    BuyProductComponent,
  ]
})
export class ProductBuyModule { }
