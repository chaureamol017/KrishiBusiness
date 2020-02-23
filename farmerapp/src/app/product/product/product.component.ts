import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { ProductService } from 'src/app/services/product.service';
// import { Product } from '../../classes/product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: [
    './product.component.scss',
    '../../common/commonStyle.scss'
  ]
})
export class ProductComponent implements OnInit {

  constructor(
    private productService: ProductService,
    private formBuilder: FormBuilder,
    private dialogRef: MatDialogRef<ProductComponent>
  ) { }

  productDetailsform;
  formTitle: any = "";

  ngOnInit() {
    var refData = this.dialogRef._containerInstance._config.data;
    if (refData.isEdit) {
      var selectedData = refData.selectedData;

      this.formTitle = "Edit Product";
      this.productDetailsform = new FormGroup({
        productId: new FormControl(selectedData.productId, [Validators.required]),
        productName: new FormControl(selectedData.productName, [Validators.required]),
        description: new FormControl(selectedData.description),
        productCategoryId: new FormControl(selectedData.categoryid),
        productGradeId: new FormControl(selectedData.gradeid),
        city: new FormControl(selectedData.city),
        availableOn: new FormControl(selectedData.availableOn),
        sellingRate: new FormControl(selectedData.sellingRate),
      });

    } else {
      this.formTitle = "Add Product";
      this.productDetailsform = new FormGroup({
        productId: new FormControl('', [Validators.required]),
        productName: new FormControl('', [Validators.required]),
        description: new FormControl(),
        productCategoryId: new FormControl(),
        productGradeId: new FormControl(),
        city: new FormControl(),
        availableOn: new FormControl(),
        sellingRate: new FormControl(),
      });
    }

  }


  saveProduct(saveProduct) {
    var productDetails = saveProduct.value;
    var userId: string = localStorage.getItem("userId");

    var product = {
      productId: (productDetails.productId) ? productDetails.productId : "",
      userId: userId,
      productName: (productDetails.productName) ? productDetails.productName : "",
      productCategoryId: (productDetails.productCategoryId) ? productDetails.productCategoryId : "",
      productGradeId: (productDetails.productGradeId) ? productDetails.productGradeId : "",
      description: (productDetails.description) ? productDetails.description : "",
      city: (productDetails.city) ? productDetails.city : "",
      sellingRate: (productDetails.sellingRate) ? productDetails.sellingRate : "",
      productQuanity: (productDetails.productQuanity) ? productDetails.productQuanity : ""
    }
    this.productService.saveProduct(product).subscribe(
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
      alert("Product saved successfully.");
      this.closeDialog();
    } else {
      alert("Error ocurred while processing.");
    }
  }

  closeDialog() {
    this.dialogRef.close();
  }
}

