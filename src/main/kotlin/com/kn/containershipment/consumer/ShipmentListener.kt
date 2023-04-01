package com.kn.containershipment.consumer
import com.kn.containershipment.model.Shipment
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ShipmentListener {
    private val objectMapper = jacksonObjectMapper()

    @RabbitListener(queues = ["shipment"])
    fun receiveShipment(shipmentJson: String) {
        val shipment = objectMapper.readValue(shipmentJson, Shipment::class.java)
        println("Received shipment: $shipment")
    }
}
