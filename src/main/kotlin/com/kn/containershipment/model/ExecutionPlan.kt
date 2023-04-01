package com.kn.containershipment.model

/**
 * ExecutionPlan is used to store information about shipment and its corresponding actions to be executed.
 */

data class ExecutionPlan(

    val id: Long = 0,

    val origin: String? = null,

    val destination: String? = null,

    val customerId: String? = null,

    val transportType: TransportType? = null,

    val temperature: TemperatureRange? = null,

    val fragile: Boolean = false,

    val notifyCustomer: Boolean = false,

    val templateId: Long = 0,

    val actions: List<ExecutionPlanAction> = listOf()
)

/**
 * ExecutionPlanAction is used to execution individual actions from the template actions in an ExecutionPlan
 */
data class ExecutionPlanAction(

    val id: Long = 0,

    val actionName: String? = null,

    val isExecuted: Boolean = false,

    val isNotify: Boolean = false
)
