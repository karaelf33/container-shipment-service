package com.kn.containershipment.service.impl

import com.kn.containershipment.dto.ShipmentDTO
import com.kn.containershipment.model.ExecutionPlan
import com.kn.containershipment.model.TransportType
import com.kn.containershipment.repository.ExecutionPlanRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyList
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class ExecutionPlanServiceImplTest {
    @InjectMocks
    private var executionPlanService: ExecutionPlanServiceImpl? = null

    @Mock
    private val executionPlanRepository: ExecutionPlanRepository? = null

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        executionPlanService = executionPlanRepository?.let { ExecutionPlanServiceImpl(it) }
    }
    @Test
    fun testCreateExecutionPlans_ValidData() {
        val shipments: MutableList<ShipmentDTO> = ArrayList()
        shipments.add(
            ShipmentDTO(
                1L,
                "destination1",
                "customerId1",
                "transportType1",
                true,
                false,
                TransportType.AIR
            )
        )
        shipments.add(
            ShipmentDTO(
                1L,
                "destination2",
                "customerId2",
                "transportType2",
                true,
                true,
                TransportType.AIR
            )
        )

        `when`(executionPlanRepository!!.saveAll(anyList())).thenReturn(ArrayList())

        val result = executionPlanService!!.createExecutionPlans(shipments)

        assertNotNull(result)
        assertEquals(0, result.size) // Assuming repository saveAll returns an empty list
        verify(executionPlanRepository, times(1)).saveAll(anyList()) // Verify repository saveAll method is called once
    }


    @Test
    fun testGetAllExecutionPlan() {
        // Mock data
        val executionPlan1 = ExecutionPlan(id = 1L, origin = "A", destination = "B")
        val executionPlan2 = ExecutionPlan(id = 2L, origin = "C", destination = "D")
        val executionPlans = listOf(executionPlan1, executionPlan2)

        `when`(executionPlanRepository!!.findAll()).thenReturn(executionPlans)

        val result = executionPlanService!!.getAllExecutionPlan()

        assertEquals(executionPlans, result)
    }
}