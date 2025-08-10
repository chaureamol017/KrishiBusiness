import { Component, OnInit } from '@angular/core';
import { Banner } from '../../shared/model/banner';
import { BannerCard } from '../../shared/model/banner-card';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  appName: any = "Krishi Business";

  heading: any = "Welcome to KRUSHI BUSINESS";
  description: any = "\"KRUSHI BUSINESS\" application help to perform online selling and buying of farm goods between farmer, retailer and buyer. "
    + "Application help to create virtual market place for connecting farmer directly with retailers and wholesalers."
    + "The farmer and buyer can create their profile online where they can update information related with the post of products(like quantity, price, bidding price etc.)."
    + "The result will be shown to the respective persons in the form of notification. Using this application seller and buyer can deal without any physical efforts."
    + "One can easily login anytime, anywhere with correct login id and password and processed for a deal.Seller can search/bid for the product which is "
    + "added by farmer so transparency about price is maintain during deal and process of online auction become simple.";


  banners: Banner[] = [
    { image: 'assets/img/krishi-business-dashboard.jpg' },
    { image: 'assets/img/Best-Agricultural-Apps.jpg' },
  ];

  cardDescription: string = "Fresh from farm";
  cards: BannerCard[] = [
    {
      image: 'assets/img/card1.png',
      title: 'Title: List Your Product',
      description: 'Easily post the details of your farm product. Set your price and make your products visible to potential buyers instantly'
    }, {
      image: 'assets/img/card2.png',
      title: 'Buyer Places The Bid',
      description: 'Buyer can now place bids for the products. Compete to offer the best price and secure fresh produce directly from the source.'
    }, {
      image: 'assets/img/card3.png',
      title: 'Winning Bid Selection',
      description: 'Dealer with the highest bid gets selected! Farmers can choose the best offer, ensuring they get the best value for their products'
    }
  ];

  constructor(
  ) { }

  ngOnInit() {
  }

  hasBanners(): boolean {
    return this.banners.length > 0;
  }
}
