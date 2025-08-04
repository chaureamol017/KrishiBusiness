import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { TopBarButton } from '../model/top-bar-button';

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.scss']
})
export class TopBarComponent implements OnInit {
  @Input('name') name = '';
  @Input('leftButtons') leftButtons: TopBarButton[] = [];
  @Input('rightButtons') rightButtons: TopBarButton[] = [];
  @Output() buttonClick: EventEmitter<string> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  onClick(action: string) {
    this.buttonClick.emit(action);
  }

}
