import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { FormValidationService } from 'src/app/services/form-validation.service';
import { ProductApiService } from 'src/app/services/product-api.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {

  constructor(
    private productService: ProductService,
    private productApiService: ProductApiService,
    private validationService: FormValidationService,
    private dialogRef: MatDialogRef<ProductComponent>
  ) { }

  productDetailsform;
  formTitle: any = "";

  ngOnInit() {
    var refData = this.dialogRef._containerInstance._config.data;
    if (refData.isEdit) {
      var selectedData = refData.selectedData;

      this.formTitle = "Edit Product";
      this.productDetailsform = this.validationService.getEditProductFormGroup(selectedData);
    } else {
      this.formTitle = "Add Product";
      this.productDetailsform = this.validationService.getAddProductFormGroup();
    }

  }

  saveProduct(saveProduct) {
    var productDetails = saveProduct.value;

    var product = this.productService.getProductForSave(productDetails);
    this.productApiService.saveProduct(product).subscribe(
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
