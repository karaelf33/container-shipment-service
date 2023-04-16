package com.kn.containershipment.service

import com.kn.containershipment.dto.ShipmentDTO
import com.kn.containershipment.model.ExecutionPlan

interface ExecutionPlanService {
    fun createExecutionPlans(shipments: List<ShipmentDTO>): List<ExecutionPlan>


}