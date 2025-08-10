import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FarmerProductService } from '../../services/farmer-product.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SnackBarService } from 'src/app/services/snack-bar.service';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/model/product';
import { QunatityUnit } from 'src/app/model/quantity-unit.enum';
import { FarmerProduct, FarmerProductRequest } from 'src/app/model/farmer-product';
import { Observable } from 'rxjs';
import { CommonUtil } from 'src/app/util/common.util';
import { DialogAction, DialogData } from 'src/app/model/dialog-data';

@Component({
  selector: 'app-add-edit-farmer-product',
  templateUrl: './add-edit-farmer-product.component.html',
  styleUrls: ['./add-edit-farmer-product.component.scss'],
  host: {
    'class': 'flex-column-stretch-gap',
  }
})
export class AddEditFarmerProductComponent implements OnInit {
  productDetailsform: FormGroup;
  isEdit: boolean = false;
  formTitle: any = '';
  products: Product[] = [];
  quantityUnits: string[] = Object.keys(QunatityUnit);
  selectedData: FarmerProduct;


  constructor(
    private snackBarService: SnackBarService,
    private productService: ProductService,
    private farmerProductService: FarmerProductService,
    private dialogRef: MatDialogRef<AddEditFarmerProductComponent>
  ) { }

  ngOnInit() {
    const refData = this.dialogRef._containerInstance._config.data;
    this.isEdit = refData.isEdit;
    if (this.isEdit) {
      this.selectedData = refData.selectedData;
      this.formTitle = 'Edit Product';
      this.productDetailsform = this.getEditProductFormGroup();
    } else {
      this.formTitle = 'Add Product';
      this.productDetailsform = this.getAddProductFormGroup();
    }

    this.getProducts();

  }

  getProducts() {
    this.productService.getProducts()
      .subscribe((response: Product[]) => this.products = response)
  }


  getAddProductFormGroup(): FormGroup {
    return new FormGroup({
      productId: new FormControl('', [Validators.required]),
      description: new FormControl(),
      quantity: new FormControl(1, [Validators.required]),
      quantityUnit: new FormControl('Kilogram', [Validators.required]),
      pricePerUnit: new FormControl('', [Validators.required]),
      city: new FormControl(),
    });
  }

  getEditProductFormGroup(): FormGroup {
    return new FormGroup({
      productId: new FormControl(this.selectedData.productId, [Validators.required]),
      description: new FormControl(this.selectedData.description),
      quantity: new FormControl(this.selectedData.quantity, [Validators.required]),
      quantityUnit: new FormControl(this.selectedData.quantityUnit, [Validators.required]),
      pricePerUnit: new FormControl(this.selectedData.pricePerUnit, [Validators.required]),
      city: new FormControl(this.selectedData.city),
      addedOn: new FormControl(this.selectedData.addedOn),
    });
  }


  addEditProduct() {
    if (!this.productDetailsform.valid) {
      this.snackBarService.notify('Plase add all required values', 'OK')
      return;
    }
    
    
    let observable: Observable<FarmerProduct>;
    if (this.isEdit) {
      const product: FarmerProductRequest = this.getProductForUpdate();
      observable = this.farmerProductService.updateFarmerProduct(product);
    } else {
      const product: FarmerProductRequest = this.getProductForSave();
      observable = this.farmerProductService.addFarmerProduct(product);
    }

    observable.subscribe(response => this.handleSuccess(response), error => this.snackBarService.notify())
  }

  handleSuccess(response) {
    this.snackBarService.notify('Product saved successfully.', 'OK');
    this.closeDialog('SAVE', true);
  }

  closeDialog(action?: DialogAction, success?: boolean) {
    if (!action) {
      action = 'CANCEL';
    }
    const data: DialogData = {
          action: action,
          success: success
    }
    this.dialogRef.close(data);
  }


  getProductForSave(): FarmerProductRequest {
    const productDetails = this.productDetailsform.value;
    const userId: number = parseInt(localStorage.getItem('userId'));
    const productId: number = CommonUtil.parseToInt(productDetails.productId);
    const quantity: number = CommonUtil.parseToInt(productDetails.quantity);
    const pricePerUnit: number = CommonUtil.parseToInt(productDetails.pricePerUnit);

    const product: FarmerProductRequest = {
      productId: productId,
      userId: userId,
      description: (productDetails.description) ? productDetails.description : '',
      quantity: quantity,
      quantityUnit: (productDetails.quantityUnit) ? productDetails.quantityUnit : '',
      pricePerUnit: pricePerUnit,
      city: (productDetails.city) ? productDetails.city : ''
    }

    return product;
  }

  getProductForUpdate(): FarmerProductRequest {
    const product: FarmerProductRequest = this.getProductForSave();
    
    product.farmerProductId = this.selectedData.farmerProductId;
    product.addedOn = this.selectedData.addedOn;

    return product;
  }
}
