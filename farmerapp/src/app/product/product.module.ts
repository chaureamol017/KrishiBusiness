import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { MaterialModule } from '../material/material.module';
import { AddEditProductComponent } from './add-edit-product/add-edit-product.component';



@NgModule({
  declarations: [
    ProductListComponent,
    AddEditProductComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    
    MaterialModule,
    SharedModule,
  ],
  exports: [
    ProductListComponent,
  ],
  entryComponents: [
    AddEditProductComponent,
  ]
})
export class ProductModule { }
