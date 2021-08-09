import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MyLoginComponent } from './my-login/my-login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ProductComponent } from './product/product.component';
import { MatButtonModule, MatDatepickerModule, MatDialogModule, MatIconModule, MatPaginatorModule, MatTableModule, MatToolbarModule } from '@angular/material';
import { AddEditProductBidComponent } from './add-edit-product-bid/add-edit-product-bid.component';
import { ProductBidComponent } from './product-bid/product-bid.component';
import { SellingProductComponent } from './selling-product/selling-product.component';
import { SharedComponentsModule } from '../shared-components/shared-components.module';



@NgModule({
  declarations: [
    MyLoginComponent, SignUpComponent,
    ProductComponent, AddEditProductBidComponent, ProductBidComponent, SellingProductComponent
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
  ]
})
export class EntryComponentsModule { }
