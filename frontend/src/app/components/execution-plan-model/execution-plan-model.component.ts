import {Component, Input, OnInit} from '@angular/core';
import {Shipment, TransportType} from "../../models/shipment.mode";

@Component({
  selector: 'execution-plan-model',
  templateUrl: './execution-plan-model.component.html',
  styleUrls: ['./execution-plan-model.component.scss']
})
export class ExecutionPlanModelComponent implements OnInit {

  @Input()
  shipment: Shipment;

  constructor() { }

  ngOnInit(): void {
  }

}
