import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerregisterComponent } from './customerregister.component';

describe('CustomerregisterComponent', () => {
  let component: CustomerregisterComponent;
  let fixture: ComponentFixture<CustomerregisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerregisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
