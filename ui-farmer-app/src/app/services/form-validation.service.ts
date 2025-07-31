import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FormValidationService {

  constructor() { }

  getMyLoginFormGroup(): FormGroup {
    return new FormGroup({
        userName: new FormControl('', [Validators.required]),
        password: new FormControl('', [Validators.required]),
      });
  }

  getSignUpFormGroup(): FormGroup {
    return new FormGroup({
        role: new FormControl('', [Validators.required]),
        firstName: new FormControl('', [Validators.required]),
        middleName: new FormControl(''),
        lastName: new FormControl('', [Validators.required]),
        emailId: new FormControl('', [Validators.required]),
        password: new FormControl('', [Validators.required]),
        confirmPassword: new FormControl('', [Validators.required]),
      });
  }

  getAddProductFormGroup(): FormGroup {
    return new FormGroup({
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

  getEditProductFormGroup(selectedData: any): FormGroup {
    return new FormGroup({
        productId: new FormControl(selectedData.productId, [Validators.required]),
        productName: new FormControl(selectedData.productName, [Validators.required]),
        description: new FormControl(selectedData.description),
        productCategoryId: new FormControl(selectedData.categoryid),
        productGradeId: new FormControl(selectedData.gradeid),
        city: new FormControl(selectedData.city),
        availableOn: new FormControl(selectedData.availableOn),
        sellingRate: new FormControl(selectedData.sellingRate),
      });
  }

  getAddProductBidFormGroup(): FormGroup {
    return new FormGroup({
        productBidId: new FormControl('', [Validators.required]),
        bidAmount: new FormControl('', [Validators.required])
      });
  }
  
  getEditProductBidFormGroup(selectedBidData: any): FormGroup {
    return new FormGroup({
        productBidId: new FormControl(selectedBidData.productBidId, [Validators.required]),
        bidAmount: new FormControl(selectedBidData.bidAmount, [Validators.required])
      });
  }
}
