import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellingProductsListComponent } from './selling-products-list.component';

describe('SellingProductsListComponent', () => {
  let component: SellingProductsListComponent;
  let fixture: ComponentFixture<SellingProductsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellingProductsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellingProductsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
