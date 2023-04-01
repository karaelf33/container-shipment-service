import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExecutionPlanComponentComponent } from './execution-plan-component.component';

describe('ExecutionPlanComponentComponent', () => {
  let component: ExecutionPlanComponentComponent;
  let fixture: ComponentFixture<ExecutionPlanComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExecutionPlanComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExecutionPlanComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
