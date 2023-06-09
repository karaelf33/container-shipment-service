import { Injectable } from '@angular/core';
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {Shipment} from "../../models/shipment.mode";
import {map} from "rxjs/operators";
import {ExecutionPlan} from "../../models/ExecutionPland.mode";

@Injectable({
  providedIn: 'root'
})
export class ExecutionPlanService {
  private EXECUTION_PLANS = '/execution-plans';
    private executionPlans: ExecutionPlan[] = [];

  constructor(private apiService: ApiService) { }

  createUser(shipment:Shipment[]): Observable<any> {
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
    getExecutionPlans(): Observable<any> {
        return this.apiService.get(this.EXECUTION_PLANS).pipe(map(
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
