import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CellActionButton } from '../model/cell-action-button';

@Component({
  selector: 'app-table-cell-action',
  templateUrl: './table-cell-action.component.html',
  styleUrls: ['./table-cell-action.component.scss']
})
export class TableCellActionComponent implements OnInit {
  @Input('actions') actions: CellActionButton[] = [];
  @Output() onActionClick: EventEmitter<string> = new EventEmitter();

  constructor() { }

  ngOnInit() {
    console.log(this.actions)
  }

  handleButtonClick(action: string) {
    this.onActionClick.emit(action);
  }
}
