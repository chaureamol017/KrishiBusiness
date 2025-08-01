import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-card-banner',
  templateUrl: './card-banner.component.html',
  styleUrls: ['./card-banner.component.scss']
})
export class CardBannerComponent implements OnInit {
  title: string = "Krishi Business";
  bodyText: string = "Fresh from farm";


  @Input() cards: { image: string; title: string; description: string }[] = [
    {
      image: 'assets/images/card1.png',
      title: 'File-based routing',
      description: 'Create stack, modal, drawer, and tab screens with minimal boilerplate using your filesystem.'
    }, {
      image: 'assets/images/card2.png',
      title: 'Use any library, SDK, or native code',
      description: 'Generate native changes or write your own native code. Use over 50 modules to create your app.'
    }, {
      image: 'assets/images/card3.png',
      title: 'Developer tools',
      description: 'Get started quickly with Expo Go, then continue with expo-dev-client for advanced tools.'
    }
  ];


  constructor() { }

  ngOnInit() {
  }

}
