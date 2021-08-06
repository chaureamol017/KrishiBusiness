import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { FormValidationService } from 'src/app/services/form-validation.service';
import { ProductBidApiService } from 'src/app/services/product-bid-api.service';

@Component({
  selector: 'app-add-edit-product-bid',
  templateUrl: './add-edit-product-bid.component.html',
  styleUrls: ['./add-edit-product-bid.component.scss']
})
export class AddEditProductBidComponent implements OnInit {


  productBidform: FormGroup;
  selectedData: any;
  selectedProductName: any;
  formTitle: any = "Bid For";
  constructor(
    private productBidApiService: ProductBidApiService,
    private validationService: FormValidationService,
    private dialogRef: MatDialogRef<AddEditProductBidComponent>
  ) { }

  ngOnInit() {
    var refData = this.dialogRef._containerInstance._config.data;
    this.selectedData = refData.selectedData;
    this.selectedProductName = this.selectedData.productName;

    if (refData.isEdit) {
      var selectedBidData = refData.selectedBidData;
      this.productBidform = this.validationService.getEditProductBidFormGroup(selectedBidData);
    } else {
      this.productBidform = this.validationService.getAddProductBidFormGroup();
    }
  }
  
  saveProductBid(productBidform) {
    var productBidDetails = productBidform.value;
    var userId: string = localStorage.getItem("userId");

    var product = {
      buyerId: userId,
      productBidId: (this.selectedData.productBidId) ? this.selectedData.productBidId : "",
      productId: (this.selectedData.productId) ? this.selectedData.productId : "",
      biddingRate: (productBidDetails.bidAmount) ? productBidDetails.bidAmount : "",
    }
    this.productBidApiService.saveProductBid(product).subscribe(
      responseData => {
        this.handleSuccessResponse(responseData);
      },
      error => {
        alert("Error ocurred while processing.");
      }
    )
  }

  
  handleSuccessResponse(responseData) {
    if (responseData.success) {
      alert("Product bid saved successfully.");
      this.closeDialog();
    } else {
      alert("Error ocurred while processing.");
    }
  }

  closeDialog() {
    this.dialogRef.close();
  }
}
