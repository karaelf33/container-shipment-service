

export interface Shipment {
    id: Number,

    origin: String,

    destination?: String,

    customerId: String,

    createdDate: Number,

    fragile: Boolean,

    notifyCustomer: Boolean,

    transportType: TransportType,
    temperatureRange: TemperatureRange
}

export enum TransportType {
    AIR,
    SEA,
    ROAD
}

export interface TemperatureRange {
    id: Number,
    min: Number,
    max: Number
}
