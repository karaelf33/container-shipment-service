package com.kn.containershipment.controller

import com.kn.containershipment.model.Shipment
import com.kn.containershipment.service.ShipmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/api/shipments")
class ShipmentController {

    @Autowired
    private lateinit var shipmentService: ShipmentService

    @GetMapping("")
    fun getAllShipments(): ResponseEntity<List<Shipment>> {
        val shipments = shipmentService.getAllShipments()
        return ResponseEntity(shipments, HttpStatus.OK)
    }
}