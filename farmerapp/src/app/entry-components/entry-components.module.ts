import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProductComponent } from './product/product.component';
import { AddEditProductBidComponent } from './add-edit-product-bid/add-edit-product-bid.component';
import { ProductBidComponent } from './product-bid/product-bid.component';
import { SellingProductComponent } from './selling-product/selling-product.component';
import { SharedComponentsModule } from '../shared-components/shared-components.module';
import { MaterialModule } from '../material/material.module';



@NgModule({
  declarations: [
    ProductComponent, AddEditProductBidComponent, ProductBidComponent, SellingProductComponent
    ],
  imports: [
    CommonModule,

    FormsModule,
    ReactiveFormsModule,

    
    MaterialModule,

    SharedComponentsModule,
  ]
})
export class EntryComponentsModule { }
