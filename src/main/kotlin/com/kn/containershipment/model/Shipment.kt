package com.kn.containershipment.model

import jakarta.persistence.*

data class Shipment(

    val id: Long = 0,

    val origin: String? = null,

    val destination: String? = null,

    val customerId: String? = null,

    val createdDate: Long = 0,

    val fragile: Boolean = false,

    val notifyCustomer: Boolean = false,

    val transportType: TransportType? = null,

    val temperatureRange: TemperatureRange? = null
)

enum class TransportType {
    AIR,
    SEA,
    ROAD
}

@Entity
@Table
data class TemperatureRange(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val min: Int = 0,
    val max: Int = 0
)
