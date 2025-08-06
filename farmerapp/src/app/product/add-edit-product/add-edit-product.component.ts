import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { ProductService } from '../../services/product.service';
import { ProductHelper } from 'src/app/util/product-helper';
import { FormGroup } from '@angular/forms';
import { ProductCategory } from 'src/app/model/product-category';
import { Product } from 'src/app/model/product';
import { DialogAction, DialogData } from 'src/app/model/dialog-data';
import { SnackBarService } from 'src/app/services/snack-bar.service';

@Component({
  selector: 'app-add-edit-product',
  templateUrl: './add-edit-product.component.html',
  styleUrls: ['./add-edit-product.component.scss']
})
export class AddEditProductComponent implements OnInit {
  productCategories: string[] = Object.keys(ProductCategory);
  productDetailsform: FormGroup;
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
      this.productDetailsform = ProductHelper.getEditProductFormGroup(selectedData);
    } else {
      this.formTitle = 'Add Product';
      this.productDetailsform = ProductHelper.getAddProductFormGroup();
    }

  }

  onSubmit() {
    var product: Product = this.getProductForSave();
    
    if(this.isEdit) {
      this.productService.updateProduct(product).subscribe(resp => this.handleSuccess(resp), this.handleFailure);
    } else {
      this.productService.saveProduct(product).subscribe(this.handleSuccess, this.handleFailure);
    }
  }

  handleSuccess(response: Product) {
    this.snackBarService.openTopCenter('Product saved successfully.', 'OK');
    this.closeDialog('SAVE', true);
  }

  handleFailure(error: any) {
    this.snackBarService.openTopCenter('Error ocurred while processing.');
  }

  getProductForSave() : Product {
    const formData: any = this.productDetailsform.value;

    const product: Product = {
      productId: (formData.productId) ? formData.productId : '',
      name: (formData.name) ? formData.name : '',
      description: (formData.description) ? formData.description : '',
      category: (formData.category) ? formData.category : ''
    }

    return product;
  }

  closeDialog(action: DialogAction, success?: boolean) {
    const data: DialogData = {
      action: action,
      success: success
    }
    this.dialogRef.close(data);
  }
}
