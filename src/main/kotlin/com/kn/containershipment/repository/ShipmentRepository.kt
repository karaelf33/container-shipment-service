package com.kn.containershipment.repository

import com.kn.containershipment.model.Shipment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShipmentRepository : JpaRepository<Shipment, String> {
}