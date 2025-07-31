import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import {
  MatTableModule, MatIconModule, MatPaginatorModule, MatButtonModule, MatDialogModule, MatToolbarModule, MatDatepickerModule
} from '@angular/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SellingProductsListComponent } from './selling-products-list/selling-products-list.component';
import { TopBarComponent } from '../shared-components/top-bar/top-bar.component';
import { SharedComponentsModule } from '../shared-components/shared-components.module';



@NgModule({
  declarations: [
    ProductListComponent,
    SellingProductsListComponent,

    
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
