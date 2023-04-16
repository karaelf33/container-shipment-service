import { Injectable } from '@angular/core';
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {Shipment} from "../../models/shipment.mode";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class ExecutionPlanService {
  private EXECUTION_PLANS = '/execution-plans';

  constructor(private apiService: ApiService) { }

  createUser(shipment:Shipment[]): Observable<any> {
      console.log(shipment)
    return this.apiService.post(this.EXECUTION_PLANS, shipment).pipe(map(
        res => {
          if (res) {
            return res;
          } else {
            console.log(res);
            return {};
          }
        }
    ));
  }
}
