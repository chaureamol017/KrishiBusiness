import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProductComponent } from './product/product.component';
import { SharedComponentsModule } from '../shared-components/shared-components.module';
import { MaterialModule } from '../material/material.module';



@NgModule({
  declarations: [
    ProductComponent,
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
