import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SellProductComponent } from './sell-product/sell-product.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../material/material.module';
import { SharedComponentsModule } from '../shared-components/shared-components.module';



@NgModule({
  declarations: [
    SellProductComponent,
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
