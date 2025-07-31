import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-top-dialog-content',
  templateUrl: './top-dialog-content.component.html',
  styleUrls: ['./top-dialog-content.component.scss']
})
export class TopDialogContentComponent implements OnInit {
  @Input('titleBarColor') titleBarColor: string = '';
  @Input('title') title: string = 'Action Form';
  @Output() closeClick: EventEmitter<any> = new EventEmitter();
  titleBarClass = '';

  constructor() { }

  ngOnInit() {
  }

  actionCloseClick() {
    this.closeClick.emit();
  }
}
