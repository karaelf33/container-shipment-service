package com.kn.containershipment.config

import com.google.gson.Gson
import com.kn.containershipment.model.Shipment
import com.kn.containershipment.repository.ShipmentRepository
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {
    @Autowired
    private lateinit var shipmentRepository: ShipmentRepository
    @RabbitListener(queues = ["shipment"])
    fun handleMessage(message: String) {
        val shipment = Gson().fromJson(message, Shipment::class.java)
        shipmentRepository.save(shipment)
    }

}
