import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ProductbidService } from 'src/app/services/productbid.service';

@Component({
  selector: 'app-addbid',
  templateUrl: './addbid.component.html',
  styleUrls: [
    './addbid.component.scss',
    '../../../common/commonStyle.scss'
  ]
})
export class AddbidComponent implements OnInit {

  productBidform;
  selectedData: any;
  selectedProductName: any;
  formTitle: any = "Bid For";
  constructor(
    private productbidService: ProductbidService,
    private dialogRef: MatDialogRef<AddbidComponent>
  ) { }

  ngOnInit() {
    var refData = this.dialogRef._containerInstance._config.data;
    this.selectedData = refData.selectedData;
    this.selectedProductName = this.selectedData.productName;

    if (refData.isEdit) {
      var selectedBidData = refData.selectedBidData;
      this.productBidform = new FormGroup({
        productBidId: new FormControl(selectedBidData.productBidId, [Validators.required]),
        bidAmount: new FormControl(selectedBidData.bidAmount, [Validators.required])
      });
    } else {
      this.productBidform = new FormGroup({
        productBidId: new FormControl('', [Validators.required]),
        bidAmount: new FormControl('', [Validators.required])
      });
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
    this.productbidService.saveProductBid(product).subscribe(
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
