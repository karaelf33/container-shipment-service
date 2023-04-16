import {Component, Input, OnInit} from '@angular/core';
import {Shipment} from "../../models/shipment.mode";
import {ShipmentSelectionService} from "../../services/shared/shipment-selection.service";
import {ExecutionPlanService} from "../../services/shared/execution-plan.service";

@Component({
    selector: 'execution-plan-model',
    templateUrl: './execution-plan-model.component.html',
    styleUrls: ['./execution-plan-model.component.scss']
})
export class ExecutionPlanModelComponent implements OnInit {

    @Input()
    shipment: Shipment;
    selectedShipments: Shipment[] = [];


    constructor(private shipmentSelectionService: ShipmentSelectionService,
                private executionPlanService: ExecutionPlanService) {
    }

    ngOnInit(): void {
    }

    getSelectedShipments() {
        this.selectedShipments = this.shipmentSelectionService.getSelectedShipments();
    }

    createExecutionPlan() {
        this.selectedShipments = this.shipmentSelectionService.getSelectedShipments();
        this.executionPlanService.createUser(this.selectedShipments).subscribe(result=>{
            console.log(result);
            }

        );


    }
}
