import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopDialogContentComponent } from './top-dialog-content.component';

describe('TopDialogContentComponent', () => {
  let component: TopDialogContentComponent;
  let fixture: ComponentFixture<TopDialogContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TopDialogContentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TopDialogContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
