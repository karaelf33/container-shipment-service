import {Component, OnInit} from '@angular/core';
import {ExecutionPlan} from "../../models/ExecutionPland.mode";
import {ExecutionPlanService} from "../../services/shared/execution-plan.service";
import {PageEvent} from "@angular/material/paginator";

@Component({
    selector: 'execution-plan-component',
    templateUrl: './execution-plan-component.component.html',
    styleUrls: ['./execution-plan-component.component.scss']
})
export class ExecutionPlanComponentComponent implements OnInit {
    executionPlans: ExecutionPlan[]= [];
    pageSize = 5
    pageIndex = 0
    pageOptions: number[] = [5, 10, 25, 50]

    constructor(private executionPlanService: ExecutionPlanService) {
    }

    ngOnInit(): void {
        this.getAllExecutionPlans();

    }

    private getAllExecutionPlans() {
        this.executionPlanService.getExecutionPlans().subscribe(result => {
            this.executionPlans = result
        })
    }

    onPageChange(event: PageEvent) {
        this.pageIndex = event.pageIndex;
        this.pageSize = event.pageSize;
        this.getAllExecutionPlans();
    }


}
