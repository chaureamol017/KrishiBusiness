import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'fa-top-dialog-content',
  templateUrl: './top-dialog-content.component.html',
  styleUrls: ['./top-dialog-content.component.scss']
})
export class TopDialogContentComponent {
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
