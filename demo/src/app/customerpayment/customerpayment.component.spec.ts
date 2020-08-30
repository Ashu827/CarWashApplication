import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerpaymentComponent } from './customerpayment.component';

describe('CustomerpaymentComponent', () => {
  let component: CustomerpaymentComponent;
  let fixture: ComponentFixture<CustomerpaymentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerpaymentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerpaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
