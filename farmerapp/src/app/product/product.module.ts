import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import {
  MatTableModule, MatIconModule, MatPaginatorModule, MatButtonModule, MatDialogModule, MatToolbarModule, MatDatepickerModule
} from '@angular/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SharedComponentsModule } from '../shared-components/shared-components.module';



@NgModule({
  declarations: [
    ProductListComponent,
  ],
  imports: [
    CommonModule,
    
    FormsModule,
    ReactiveFormsModule,
    
    MatButtonModule,
    MatDatepickerModule,
    MatDialogModule,
    MatIconModule,
    MatPaginatorModule,
    MatTableModule,
    MatToolbarModule,

    SharedComponentsModule,
  ],
  exports: [
    ProductListComponent,
  ]
})
export class ProductModule { }
