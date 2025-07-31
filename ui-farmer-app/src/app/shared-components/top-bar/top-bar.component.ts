import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.scss']
})
export class TopBarComponent implements OnInit {
  @Output() addClick: EventEmitter<any> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  add() {
    this.addClick.emit();
  }
}
