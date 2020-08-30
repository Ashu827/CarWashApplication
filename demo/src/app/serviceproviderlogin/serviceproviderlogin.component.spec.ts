import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceproviderloginComponent } from './serviceproviderlogin.component';

describe('ServiceproviderloginComponent', () => {
  let component: ServiceproviderloginComponent;
  let fixture: ComponentFixture<ServiceproviderloginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceproviderloginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceproviderloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
