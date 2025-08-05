import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SharedComponentsModule } from '../shared-components/shared-components.module';
import { ProductComponent } from './product/product.component';
import { MaterialModule } from '../material/material.module';



@NgModule({
  declarations: [
    ProductListComponent,
    ProductComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    
    MaterialModule,
    SharedComponentsModule,
  ],
  exports: [
    ProductListComponent,
  ]
})
export class ProductModule { }
