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
