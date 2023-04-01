import {Component, OnInit} from '@angular/core';
import {Shipment, TransportType} from "./models/shipment.mode";
import {ShipmentService} from "./services/shipment.service";

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent implements OnInit{

  AIR: TransportType = TransportType.AIR;
  ROAD: TransportType = TransportType.ROAD;
  SEA: TransportType = TransportType.SEA;

  shipments: Shipment[] = [];
  selectedShipment: Shipment;

  constructor(private shipmentService: ShipmentService) {
  }

  ngOnInit(): void {
    this.shipments = this.shipmentService.getShipments();
  }


}
