import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { ProductService } from '../../services/product.service';
import { ProductHelper } from 'src/app/util/product-helper';
import { FormGroup } from '@angular/forms';
import { ProductCategory } from 'src/app/model/product-category';
import { Product } from 'src/app/model/product';

@Component({
  selector: 'app-add-edit-product',
  templateUrl: './add-edit-product.component.html',
  styleUrls: ['./add-edit-product.component.scss']
})
export class AddEditProductComponent implements OnInit {
  productCategories: string[] = Object.keys(ProductCategory);
  productDetailsform: FormGroup;
  isEdit: boolean = false;
  formTitle: any = "";

  constructor(
    private productService: ProductService,
    private dialogRef: MatDialogRef<AddEditProductComponent>
  ) {
  }

  ngOnInit() {
    var refData = this.dialogRef._containerInstance._config.data;
    this.isEdit = refData.isEdit;
    if (this.isEdit) {
      var selectedData = refData.selectedData;

      this.formTitle = "Edit Product";
      this.productDetailsform = ProductHelper.getEditProductFormGroup(selectedData);
    } else {
      this.formTitle = "Add Product";
      this.productDetailsform = ProductHelper.getAddProductFormGroup();
    }

  }

  onSubmit() {
    var product: Product = this.getProductForSave();
    
    if(this.isEdit) {
      this.updateProduct(product);
    } else {
      this.saveProduct(product);
    }
  }

  saveProduct(product: Product) {
    
    this.productService.saveProduct(product).subscribe(
      responseData => {
        this.handleSuccessResponse(responseData);
      },
      error => {
        alert("Error ocurred while processing.");
      }
    )
  }

  updateProduct(product: Product) {
    this.productService.updateProduct(product)
    .subscribe(this.handleSuccessResponse,
      error => {
        alert("Error ocurred while processing.");
      }
    );
  }

  handleSuccessResponse(responseData) {
      alert("Product saved successfully.");
      this.closeDialog();
  }

  getProductForSave() : any {
    var product = {
      productId: (this.productDetailsform.value.productId) ? this.productDetailsform.value.productId : "",
      name: (this.productDetailsform.value.name) ? this.productDetailsform.value.name : "",
      description: (this.productDetailsform.value.description) ? this.productDetailsform.value.description : "",
      category: (this.productDetailsform.value.category) ? this.productDetailsform.value.category : ""
    }

    return product;
  }
  closeDialog() {
    this.dialogRef.close();
  }
}
