import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor() { }

  getProductForSave(productDetails: any) : any {
    var userId: string = localStorage.getItem("userId");

    var product = {
      productId: (productDetails.productId) ? productDetails.productId : "",
      userId: userId,
      productName: (productDetails.productName) ? productDetails.productName : "",
      productCategoryId: (productDetails.productCategoryId) ? productDetails.productCategoryId : "",
      productGradeId: (productDetails.productGradeId) ? productDetails.productGradeId : "",
      description: (productDetails.description) ? productDetails.description : "",
      city: (productDetails.city) ? productDetails.city : "",
      sellingRate: (productDetails.sellingRate) ? productDetails.sellingRate : "",
      productQuanity: (productDetails.productQuanity) ? productDetails.productQuanity : ""
    }

    return product;
  }
}
