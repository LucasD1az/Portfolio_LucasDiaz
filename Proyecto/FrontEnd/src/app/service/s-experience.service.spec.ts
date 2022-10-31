import { TestBed } from '@angular/core/testing';

import { SExperienceService } from './s-experience.service';

describe('SExperienceService', () => {
  let service: SExperienceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SExperienceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
