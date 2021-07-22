import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-default-header',
  templateUrl: './default-header.component.html',
  styleUrls: [
    './default-header.component.scss',
    '../../common/commonStyle.scss'
  ]
})
export class DefaultHeaderComponent implements OnInit {
  
  appName: any = "Krishi Business";

  constructor() { }

  ngOnInit() {
  }

}
