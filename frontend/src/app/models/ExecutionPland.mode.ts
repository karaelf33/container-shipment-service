import {TemperatureRange, TransportType} from "./shipment.mode";

export interface ExecutionPlan {
    id: Number,

    origin: String,

    destination?: String,

    notifyCustomer: boolean,

    transportType: TransportType,

    fragile: Boolean,

    temperatureRange: TemperatureRange
}
