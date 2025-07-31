import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-default-container',
  templateUrl: './default-container.component.html',
  styleUrls: ['./default-container.component.scss']
})
export class DefaultContainerComponent implements OnInit {

  heading: any = "Welcome to KRUSHI BUSINESS";
  description1: any = "\"KRUSHI BUSINESS\" application help to perform online selling and buying of farm goods between farmer, retailer and buyer. " 
            + "Application help to create virtual market place for connecting farmer directly with retailers and wholesalers."
            + "The farmer and buyer can create their profile online where they can update information related with the post of products(like quantity, price, bidding price etc.)."
            + "The result will be shown to the respective persons in the form of notification. Using this application seller and buyer can deal without any physical efforts."
            + "One can easily login anytime, anywhere with correct login id and password and processed for a deal.Seller can search/bid for the product which is "
            + "added by farmer so transparency about price is maintain during deal and process of online auction become simple.";
  servicePoints: string[] = ["Farmer post product details.", "Retailers/wholesalers bid for product.", "Dealer with highest bid value get select."]

  constructor() { }

  ngOnInit() {
  }

}
