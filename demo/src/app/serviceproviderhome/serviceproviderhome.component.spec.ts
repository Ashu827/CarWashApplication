import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceproviderhomeComponent } from './serviceproviderhome.component';

describe('ServiceproviderhomeComponent', () => {
  let component: ServiceproviderhomeComponent;
  let fixture: ComponentFixture<ServiceproviderhomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceproviderhomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceproviderhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
