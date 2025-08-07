import { Component, Input, OnInit } from '@angular/core';
import { BannerCard } from '../model/banner-card';

@Component({
  selector: 'app-banner-card',
  templateUrl: './banner-card.component.html',
  styleUrls: ['./banner-card.component.scss']
})
export class BannerCardComponent implements OnInit {
  @Input() title: string = "Krishi Business";
  @Input() description: string = "How are you";
  @Input() cards: BannerCard[] = [];

  constructor() { }

  ngOnInit() {
  }

  hasCards() {
    return this.cards.length > 0;
  }

}
