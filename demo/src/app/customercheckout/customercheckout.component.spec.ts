import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomercheckoutComponent } from './customercheckout.component';

describe('CustomercheckoutComponent', () => {
  let component: CustomercheckoutComponent;
  let fixture: ComponentFixture<CustomercheckoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomercheckoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomercheckoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
