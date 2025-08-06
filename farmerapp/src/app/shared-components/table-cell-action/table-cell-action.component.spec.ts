import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableCellActionComponent } from './table-cell-action.component';

describe('TableCellActionComponent', () => {
  let component: TableCellActionComponent;
  let fixture: ComponentFixture<TableCellActionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableCellActionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableCellActionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
