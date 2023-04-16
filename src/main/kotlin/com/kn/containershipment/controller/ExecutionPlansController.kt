package com.kn.containershipment.controller

import com.kn.containershipment.dto.ShipmentDTO
import com.kn.containershipment.model.ExecutionPlan
import com.kn.containershipment.model.Shipment
import com.kn.containershipment.service.ExecutionPlanService
import com.kn.containershipment.service.ShipmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/api/execution-plans")
class ExecutionPlansController {
    @Autowired
    private lateinit var executionPlanService: ExecutionPlanService

    @PostMapping("")
    fun createExecutionPlans(@RequestBody shipments: List<ShipmentDTO>): ResponseEntity<List<ExecutionPlan>> {
        val executionPlans = executionPlanService.createExecutionPlans(shipments);
        return ResponseEntity(executionPlans, HttpStatus.OK)
    }
}