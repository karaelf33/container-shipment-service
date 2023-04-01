import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExecutionPlanModelComponent } from './execution-plan-model.component';

describe('CreateExecutionPlanModelComponent', () => {
  let component: ExecutionPlanModelComponent;
  let fixture: ComponentFixture<ExecutionPlanModelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExecutionPlanModelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExecutionPlanModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
