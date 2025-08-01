import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.scss']
})
export class BannerComponent implements OnInit {
    currentBannerIndex: number = 0;
    banners: { image: string }[] = []; // Example structure for banners
  
    constructor() { }
  
    ngOnInit() {
      this.banners = [
        { image: 'assets/img/krishi-business-dashboard.jpg' },
        { image: 'assets/img/Best-Agricultural-Apps.jpg' },
      ];
    }
  
    showPrevBanner() {
      this.currentBannerIndex = (this.currentBannerIndex - 1 + this.banners.length) % this.banners.length;
    }
  
    showNextBanner() {
      this.currentBannerIndex = (this.currentBannerIndex + 1) % this.banners.length;
    }
  
    showBannerAtIndex(index: number) {
      this.currentBannerIndex = index;
    }


}
