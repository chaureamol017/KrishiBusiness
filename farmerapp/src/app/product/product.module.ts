import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import {
  MatTableModule, MatIconModule, MatPaginatorModule, MatButtonModule, MatDialogModule, MatToolbarModule, MatDatepickerModule
} from '@angular/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';



@NgModule({
  declarations: [ProductListComponent],
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

  ],
  exports: [
    ProductListComponent,
  ]
})
export class ProductModule { }
