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
      categoryId: new FormControl(selectedData.category),
    });
  }

}