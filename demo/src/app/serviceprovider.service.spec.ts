import { TestBed } from '@angular/core/testing';

import { ServiceproviderService } from './serviceprovider.service';

describe('ServiceproviderService', () => {
  let service: ServiceproviderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceproviderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
