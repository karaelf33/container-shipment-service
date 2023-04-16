package com.kn.containershipment.dto

import com.kn.containershipment.model.TemperatureRange
import com.kn.containershipment.model.TransportType

data class ShipmentDTO(
    val shipmentId: Long = 0,
    val origin: String? = null,
    val destination: String? = null,
    val customerId: String? = null,
    val fragile: Boolean = false,
    val notifyCustomer: Boolean = false,
    val transportType: TransportType? = null,
    val temperatureRange: TemperatureRange? = null
)