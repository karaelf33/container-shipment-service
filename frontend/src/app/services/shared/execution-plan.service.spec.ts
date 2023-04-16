import { TestBed } from '@angular/core/testing';

import { ExecutionPlanService } from './execution-plan.service';

describe('ExecutionPlanService', () => {
  let service: ExecutionPlanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExecutionPlanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
