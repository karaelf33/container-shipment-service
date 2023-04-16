import {Component, OnInit} from '@angular/core';
import {Shipment, TransportType} from "./models/shipment.mode";
import {ShipmentService} from "./services/shared/shipment.service";
import {PageEvent} from "@angular/material/paginator";
import {ShipmentSelectionService} from "./services/shared/shipment-selection.service";

@Component({
    selector: 'app-root',
    templateUrl: 'app.component.html',
    styleUrls: ['app.component.scss']
})
export class AppComponent implements OnInit {

    AIR: TransportType = TransportType.AIR;
    ROAD: TransportType = TransportType.ROAD;
    SEA: TransportType = TransportType.SEA;

    shipments: Shipment[] = [];
    selectedShipment: Shipment;
    pageSize = 5;
    pageIndex = 0;
    pageOptions: number[] = [5, 10, 25, 50];

    constructor(private shipmentService: ShipmentService,
                private shipmentSelectionService: ShipmentSelectionService) {
    }

    ngOnInit(): void {
        this.getNewShipments();
    }

    onPageChange(event: PageEvent) {
        this.pageIndex = event.pageIndex;
        this.pageSize = event.pageSize;
        this.getNewShipments();
    }


    getNewShipments() {
        this.shipmentService.getShipments().subscribe(result => {
            this.shipments = result;
        })
    }

    onShipmentSelected(shipment: Shipment, isChecked: boolean) {
        if (isChecked) {
            this.shipmentSelectionService.addSelectedShipment(shipment);
        } else {
            this.shipmentSelectionService.removeSelectedShipment(shipment);
        }
    }

}
