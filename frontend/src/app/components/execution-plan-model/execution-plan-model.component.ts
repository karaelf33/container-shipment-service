import {Component, Input, OnInit} from '@angular/core';
import {Shipment, TransportType} from "../../models/shipment.mode";
import {ShipmentSelectionService} from "../../services/shared/shipment-selection.service";

@Component({
    selector: 'execution-plan-model',
    templateUrl: './execution-plan-model.component.html',
    styleUrls: ['./execution-plan-model.component.scss']
})
export class ExecutionPlanModelComponent implements OnInit {

    @Input()
    shipment: Shipment;
    selectedShipments: Shipment[] = [];


    constructor(private shipmentSelectionService: ShipmentSelectionService) {
    }

    ngOnInit(): void {
    }

    getSelectedShipments() {
        this.selectedShipments = this.shipmentSelectionService.getSelectedShipments();
    }

    createExecutionPlan() {
        this.selectedShipments = this.shipmentSelectionService.getSelectedShipments();

    }
}
