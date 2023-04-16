package com.kn.containershipment.model


import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.Data
import lombok.EqualsAndHashCode
import lombok.ToString
import org.hibernate.Hibernate

@Entity
@Table(name = "shipment")
data class Shipment(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val shipmentId: Long = 0,

    val origin: String? = null,

    val destination: String? = null,

    val customerId: String? = null,

    val createdDate: Long = 0,

    val fragile: Boolean = false,

    val notifyCustomer: Boolean = false,

    val transportType: TransportType? = null,
    @OneToOne(cascade = [CascadeType.ALL])
    val temperatureRange: TemperatureRange? = null
)

enum class TransportType {
    AIR,
    SEA,
    ROAD
}

@Entity
@Table
@Data
data class TemperatureRange(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    val id: Long = 0,
    val min: Int = 0,
    val max: Int = 0
)