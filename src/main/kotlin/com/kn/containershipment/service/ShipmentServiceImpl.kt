package com.kn.containershipment.service

import com.kn.containershipment.model.Shipment
import com.kn.containershipment.repository.ShipmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShipmentServiceImpl(private val shipmentRepository: ShipmentRepository) : ShipmentService {


    override fun getAllShipments(): List<Shipment> {
        return shipmentRepository.findAll()
    }
}