package com.kn.containershipment.service

import com.kn.containershipment.model.Shipment

interface ShipmentService {
    fun getAllShipments(): List<Shipment>

}