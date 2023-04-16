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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Shipment

        return shipmentId == other.shipmentId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(shipmentId = $shipmentId , origin = $origin , destination = $destination , customerId = $customerId , createdDate = $createdDate , fragile = $fragile , notifyCustomer = $notifyCustomer , transportType = $transportType , temperatureRange = $temperatureRange )"
    }
}

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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as TemperatureRange

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , min = $min , max = $max )"
    }
}