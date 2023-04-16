package com.kn.containershipment.service.impl

import com.kn.containershipment.model.Shipment
import com.kn.containershipment.repository.ShipmentRepository
import com.kn.containershipment.service.ShipmentService
import org.springframework.stereotype.Service

@Service
class ShipmentServiceImpl(private val shipmentRepository: ShipmentRepository) : ShipmentService {


    override fun getAllShipments(): List<Shipment> {
        return shipmentRepository.findAll()
    }
}