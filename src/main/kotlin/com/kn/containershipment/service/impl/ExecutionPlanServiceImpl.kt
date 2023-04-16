package com.kn.containershipment.service.impl

import com.kn.containershipment.dto.ShipmentDTO
import com.kn.containershipment.model.ExecutionPlan
import com.kn.containershipment.repository.ExecutionPlanRepository
import com.kn.containershipment.service.ExecutionPlanService
import org.springframework.stereotype.Service

@Service
class ExecutionPlanServiceImpl(private val executionPlanRepository: ExecutionPlanRepository) : ExecutionPlanService {


    override fun createExecutionPlans(shipments: List<ShipmentDTO>): List<ExecutionPlan> {
        val exe: List<ExecutionPlan> = shipments.map { shipmentDto ->
            ExecutionPlan(
                origin = shipmentDto.origin,
                destination = shipmentDto.destination,
                customerId = shipmentDto.customerId,
                transportType = shipmentDto.transportType,
                temperature = shipmentDto.temperatureRange,
                fragile = shipmentDto.fragile,
                notifyCustomer = shipmentDto.notifyCustomer
            )
        }
        return executionPlanRepository.saveAll(exe)


    }

    override fun getAllExecutionPlan(): List<ExecutionPlan> {
        return executionPlanRepository.findAll()

    }
}