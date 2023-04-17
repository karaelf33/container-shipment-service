import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { ExecutionPlanModelComponent } from './components/execution-plan-model/execution-plan-model.component';
import { ExecutionPlanComponentComponent } from './components/execution-plan/execution-plan-component.component';
import {ShipmentService} from "./services/shared/shipment.service";
import {ApiService} from "./services/api.service";
import {HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatSnackBarModule} from "@angular/material/snack-bar";

@NgModule({
  declarations: [
    AppComponent,
    ExecutionPlanModelComponent,
    ExecutionPlanComponentComponent
  ],
    imports: [
        FormsModule,
        BrowserModule,
        HttpClientModule,
        BrowserAnimationsModule,
        MatPaginatorModule,
        MatSnackBarModule
    ],
  providers: [
    ApiService,
    ShipmentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
