import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FarmerProductService } from '../../services/farmer-product.service';
import { FormValidationService } from '../../services/form-validation.service';

@Component({
  selector: 'app-add-edit-farmer-product',
  templateUrl: './add-edit-farmer-product.component.html',
  styleUrls: ['./add-edit-farmer-product.component.scss']
})
export class AddEditFarmerProductComponent implements OnInit {
  productDetailsform;
  isEdit: boolean = false;
  formTitle: any = "";


  constructor(
    private farmerProductService: FarmerProductService,
    private validationService: FormValidationService,
    private dialogRef: MatDialogRef<AddEditFarmerProductComponent>
  ) { }

  ngOnInit() {
    var refData = this.dialogRef._containerInstance._config.data;
    this.isEdit = refData.isEdit;
    if (this.isEdit) {
      var selectedData = refData.selectedData;

      this.formTitle = "Edit Product";
      this.productDetailsform = this.validationService.getEditProductFormGroup(selectedData);
    } else {
      this.formTitle = "Add Product";
      this.productDetailsform = this.validationService.getAddProductFormGroup();
    }

  }

  addEditProduct(saveProduct) {
    var productDetails = saveProduct.value;

    var product = this.getProductForSave(productDetails);
    
    if(this.isEdit) {
      this.updateProduct(product);
    } else {
      this.saveProduct(product);
    }
  }

  saveProduct(product) {
    this.farmerProductService.saveProduct1(product).subscribe(
      responseData => {
        this.handleSuccessResponse(responseData);
      },
      error => {
        alert("Error ocurred while processing.");
      }
    )
  }

  updateProduct(product) {
    this.farmerProductService.updateProduct1(product).subscribe(
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

  
  getProductForSave(productDetails: any) : any {
    var userId: string = localStorage.getItem("userId");

    var product = {
      productId: (productDetails.productId) ? productDetails.productId : "",
      productName: (productDetails.productName) ? productDetails.productName : "",
      description: (productDetails.description) ? productDetails.description : ""
    }

    return product;
  }
}
