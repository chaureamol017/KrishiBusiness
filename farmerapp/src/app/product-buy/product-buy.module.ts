import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BuyProductComponent } from './buy-product/buy-product.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../material/material.module';
import { AddEditProductBidComponent } from './add-edit-product-bid/add-edit-product-bid.component';
import { AddRatingReviewComponent } from './add-rating-review/add-rating-review.component';



@NgModule({
  declarations: [
    AddEditProductBidComponent,
    AddRatingReviewComponent,
    BuyProductComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,

    MaterialModule,
    SharedModule,
  ],
  exports: [
    BuyProductComponent,
  ],
  entryComponents: [
    AddEditProductBidComponent,
    AddRatingReviewComponent,
  ],
})
export class ProductBuyModule { }
