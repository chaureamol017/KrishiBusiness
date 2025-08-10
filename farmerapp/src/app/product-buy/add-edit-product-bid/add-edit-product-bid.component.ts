import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { ProductBidService } from '../../services/product-bid.service';
import { FarmerProduct } from 'src/app/model/farmer-product';
import { FarmerProductBid, FarmerProductBidRequest } from 'src/app/model/farmer-product-bid.model';
import { SnackBarService } from 'src/app/services/snack-bar.service';
import { CommonUtil } from 'src/app/util/common.util';
import { DialogAction, DialogData } from 'src/app/model/dialog-data';
import { ApiResponse } from 'src/app/model/api-response.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-add-edit-product-bid',
  templateUrl: './add-edit-product-bid.component.html',
  styleUrls: ['./add-edit-product-bid.component.scss'],
  host: {
    'class': 'flex-column-stretch-gap',
  }
})
export class AddEditProductBidComponent implements OnInit {
  productBidForm: FormGroup;
  formTitle: string = 'Bid for product';
  selectedProduct: FarmerProduct;
  existingBid: FarmerProductBid;

  constructor(
    private snackBarService: SnackBarService,
    private productBidService: ProductBidService,
    private dialogRef: MatDialogRef<AddEditProductBidComponent>
  ) {
  }

  ngOnInit() {
    const refData = this.dialogRef._containerInstance._config.data;
    this.selectedProduct = refData.selectedData;
    this.productBidForm = this.getProductBidFormGroup();
    this.formTitle = 'Bid for ' + this.selectedProduct.product.name;
    this.checkExistingBid();
  }

  getProductBidFormGroup(): FormGroup {
    return new FormGroup({
      bidAmount: new FormControl('', [Validators.required])
    });
  }

  checkExistingBid() {
    const productId: number = this.selectedProduct.productId;
    this.productBidService.getBid(productId).subscribe(
      (response: FarmerProductBid) => this.handleGetSuccess(response),
      error => this.handleError(error, 'Error occurred while fetching existing bid.')
    );
  }

  handleGetSuccess(response: FarmerProductBid): void {
    if (response) {
      this.existingBid = response;
      this.productBidForm.setValue({ 'bidAmount': response.quotedPricePerUnit });
    }
  }

  handleError(error: any, message?: string): void {
    this.snackBarService.notify(message)
  }

  saveProductBid() {
    const productBidDetails = this.productBidForm.value;
    const userId: number = CommonUtil.parseToInt(localStorage.getItem("userId"));
    const productId: number = this.selectedProduct.farmerProductId;
    const bidAmount: number = CommonUtil.parseToInt(productBidDetails.bidAmount);

    let observable: Observable<ApiResponse<FarmerProductBid>>;
    if (this.existingBid) {
      const request: FarmerProductBidRequest = {
        farmerProductBidId: this.existingBid.farmerProductBidId,
        farmerProductId: productId,
        buyerUserId: userId,
        quotedPricePerUnit: bidAmount,
        bidOn: new Date()
      }
      observable = this.productBidService.updateProductBid(request)
    } else {
      const request: FarmerProductBidRequest = {
        farmerProductId: productId,
        buyerUserId: userId,
        quotedPricePerUnit: bidAmount,
        bidOn: new Date()
      }
      observable = this.productBidService.saveProductBid(request)
    }
    observable.subscribe(
      (response: ApiResponse<FarmerProductBid>) => this.handleSaveSuccess(response),
      error => this.handleError(error)
    )
  }

  handleSaveSuccess(response: ApiResponse<FarmerProductBid>) {
    if (response.success) {
      this.snackBarService.notify("Product bid saved successfully.");
      this.closeDialog('SAVE', true);
    } else {
      this.snackBarService.notify("Error occurred while saving product bid.");
    }
  }

  closeDialog(action: DialogAction, success?: boolean) {
    const data: DialogData = {
      action: action,
      success: success
    };
    this.dialogRef.close(data);
  }
}
