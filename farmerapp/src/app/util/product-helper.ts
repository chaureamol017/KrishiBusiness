import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Product } from "../model/product";

export class ProductHelper {

  public static getAddProductFormGroup(): FormGroup {
    return new FormGroup({
      productId: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      description: new FormControl(),
      category: new FormControl(),
    });
  }

  public static getEditProductFormGroup(selectedData: Product): FormGroup {
    return new FormGroup({
      productId: new FormControl(selectedData.productId, [Validators.required]),
      name: new FormControl(selectedData.name, [Validators.required]),
      description: new FormControl(selectedData.description),
      category: new FormControl(selectedData.category),
    });
  }

  public static getProductFromFormGroup(formGroup: FormGroup) : Product {
    const formData: any = formGroup.value;

    const product: Product = {
      productId: (formData.productId) ? formData.productId : '',
      name: (formData.name) ? formData.name : '',
      description: (formData.description) ? formData.description : '',
      category: (formData.category) ? formData.category : ''
    }

    return product;
  }
}