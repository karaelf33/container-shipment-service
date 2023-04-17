package com.kn.containershipment.dto

import com.kn.containershipment.model.TemperatureRange
import com.kn.containershipment.model.TransportType
import org.jetbrains.annotations.NotNull

data class ShipmentDTO(
    @NotNull
    val shipmentId: Long = 0,
    @NotNull
    val origin: String? = null,
    @NotNull
    val destination: String? = null,
    @NotNull
    val customerId: String? = null,
    val fragile: Boolean = false,
    val notifyCustomer: Boolean = false,
    val transportType: TransportType? = null,
    val temperatureRange: TemperatureRange? = null
)