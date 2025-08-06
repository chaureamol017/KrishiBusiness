import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { ProductService } from '../../services/product.service';
import { ProductHelper } from '../../util/product-helper';
import { FormGroup } from '@angular/forms';
import { ProductCategory } from '../../model/product-category';
import { Product } from '../../model/product';
import { DialogAction, DialogData } from '../../model/dialog-data';
import { SnackBarService } from '../../services/snack-bar.service';

@Component({
  selector: 'app-add-edit-product',
  templateUrl: './add-edit-product.component.html',
  styleUrls: ['./add-edit-product.component.scss']
})
export class AddEditProductComponent implements OnInit {
  productCategories: string[] = Object.keys(ProductCategory);
  formGroupInstance: FormGroup;
  isEdit: boolean = false;
  formTitle: string = '';

  constructor(
    private snackBarService: SnackBarService,
    private productService: ProductService,
    private dialogRef: MatDialogRef<AddEditProductComponent>
  ) {
  }

  ngOnInit() {
    var refData = this.dialogRef._containerInstance._config.data;
    this.isEdit = refData.isEdit;
    if (this.isEdit) {
      var selectedData = refData.selectedData;

      this.formTitle = 'Edit Product';
      this.formGroupInstance = ProductHelper.getEditProductFormGroup(selectedData);
    } else {
      this.formTitle = 'Add Product';
      this.formGroupInstance = ProductHelper.getAddProductFormGroup();
    }

  }

  onSubmit() {
    var product: Product = ProductHelper.getProductFromFormGroup(this.formGroupInstance);
    
    if(this.isEdit) {
      this.productService.updateProduct(product)
        .subscribe(resp => this.handleSuccess(resp), err => this.handleFailure(err));
    } else {
      this.productService.saveProduct(product)
        .subscribe(resp => this.handleSuccess(resp), err => this.handleFailure(err));
    }
  }

  handleSuccess(response: Product) {
    this.snackBarService.openTopCenter('Product saved successfully.', 'OK');
    this.closeDialog('SAVE', true);
  }

  handleFailure(error: any, message?: string) {
    if (!message) {
      message = 'Error ocurred while processing.';
    }
    this.snackBarService.openTopCenter(message);
  }


  closeDialog(action: DialogAction, success?: boolean) {
    const data: DialogData = {
      action: action,
      success: success
    }
    this.dialogRef.close(data);
  }
}
