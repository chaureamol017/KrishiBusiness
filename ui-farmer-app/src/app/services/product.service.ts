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
      productName: (productDetails.productName) ? productDetails.productName : "",
      description: (productDetails.description) ? productDetails.description : ""
    }

    return product;
  }
}
