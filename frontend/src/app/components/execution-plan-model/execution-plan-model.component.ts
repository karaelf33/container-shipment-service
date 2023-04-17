import {Component, Input, OnInit} from '@angular/core';
import {Shipment} from "../../models/shipment.mode";
import {ShipmentSelectionService} from "../../services/shared/shipment-selection.service";
import {ExecutionPlanService} from "../../services/shared/execution-plan.service";
import {MatSnackBar} from "@angular/material/snack-bar";

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
                private executionPlanService: ExecutionPlanService,
                private snackBar: MatSnackBar) {
    }

    ngOnInit(): void {
    }

    getSelectedShipments() {
        this.selectedShipments = this.shipmentSelectionService.getSelectedShipments();
    }

    createExecutionPlan() {
        this.selectedShipments = this.shipmentSelectionService.getSelectedShipments();
        this.executionPlanService.createUser(this.selectedShipments).subscribe(
            result => {
                result.forEach((plan, index) => {
                    setTimeout(() => {
                        this.snackBar.open(`Execution Plan created successfully! ID=${plan.id}`, 'Close', {
                            duration: 3000,
                            panelClass: ['snackbar-success', 'custom-snackbar'], // Add custom CSS class
                            verticalPosition: 'top'
                        });
                    }, index * 1000);
                });
            },
            error => {
                console.error(error);
            }
        );
    }
}
