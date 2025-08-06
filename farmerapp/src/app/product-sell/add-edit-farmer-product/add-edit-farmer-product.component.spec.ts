import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditFarmerProductComponent } from './add-edit-farmer-product.component';

describe('AddEditFarmerProductComponent', () => {
  let component: AddEditFarmerProductComponent;
  let fixture: ComponentFixture<AddEditFarmerProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddEditFarmerProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditFarmerProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
