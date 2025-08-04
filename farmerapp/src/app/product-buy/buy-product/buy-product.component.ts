import { Component, OnInit } from '@angular/core';
import { TopBarButton } from '../../shared-components/model/top-bar-button';

@Component({
  selector: 'app-buy-product',
  templateUrl: './buy-product.component.html',
  styleUrls: ['./buy-product.component.scss']
})
export class BuyProductComponent implements OnInit {
  buttons: TopBarButton[] = [
    {title: 'Create', action: 'create', icon: 'add'}
  ];

  constructor() { }

  ngOnInit() {
  }

  handleButtonClick($event) {
    console.log($event);
  }
}
