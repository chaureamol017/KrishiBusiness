import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopDialogContentComponent } from './top-dialog-content.component';

describe('TopDialogContentComponent', () => {
  let component: TopDialogContentComponent;
  let fixture: ComponentFixture<TopDialogContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopDialogContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopDialogContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
