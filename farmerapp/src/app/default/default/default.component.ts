import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: [
    './default.component.scss',
    '../../common/commonStyle.scss'
  ]
})
export class DefaultComponent implements OnInit {

  constructor(
    // private dilog: MatDialog
  ) { }

  ngOnInit() {
  }

}
