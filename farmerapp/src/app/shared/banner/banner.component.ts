import { Component, Input, OnInit } from '@angular/core';
import { Banner } from '../model/banner';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.scss']
})
export class BannerComponent implements OnInit {
  @Input() banners: Banner[] = [];
  currentBannerIndex: number = 0;
  private bannerInterval: any;

  constructor() {
  }

  ngOnInit() {
    this.bannerInterval = setInterval(() => {
      this.showNextBanner();
    }, 4000);
  }

  ngOnDestroy() {
    if (this.bannerInterval) {
      clearInterval(this.bannerInterval);
    }
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
