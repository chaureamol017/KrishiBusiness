import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import {
  MatTableModule, MatIconModule, MatPaginatorModule, MatButtonModule, MatDialogModule, MatToolbarModule, MatDatepickerModule
} from '@angular/material';
import { ProductComponent } from './product/product.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { BidlistComponent } from './bidproduct/bidlist/bidlist.component';
import { AddbidComponent } from './bidproduct/addbid/addbid.component';



@NgModule({
  declarations: [ProductListComponent, ProductComponent, BidlistComponent, AddbidComponent],
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
    ProductComponent,
    ProductListComponent,
    BidlistComponent,
    BidlistComponent,
  ]
})
export class ProductModule { }
