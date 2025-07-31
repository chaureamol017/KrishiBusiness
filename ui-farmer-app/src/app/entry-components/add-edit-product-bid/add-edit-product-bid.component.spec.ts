import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditProductBidComponent } from './add-edit-product-bid.component';

describe('AddEditProductBidComponent', () => {
  let component: AddEditProductBidComponent;
  let fixture: ComponentFixture<AddEditProductBidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddEditProductBidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditProductBidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
