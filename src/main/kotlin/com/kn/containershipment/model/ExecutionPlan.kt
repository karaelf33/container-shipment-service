package com.kn.containershipment.model

import jakarta.persistence.*
import lombok.Data

/**
 * ExecutionPlan is used to store information about shipment and its corresponding actions to be executed.
 */

@Entity
@Table(name = "execution_plan")
data class ExecutionPlan(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val origin: String? = null,

    val destination: String? = null,

    val customerId: String? = null,
    @Enumerated(EnumType.STRING)
    @Column(name = "transport_type")
    val transportType: TransportType? = null,

    @OneToOne(cascade = [CascadeType.ALL])
    val temperature: TemperatureRange? = null,

    val fragile: Boolean = false,

    val notifyCustomer: Boolean = false,

    val templateId: Long = 0,
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "execution_plan_id")
    val actions: List<ExecutionPlanAction> = listOf()
)

/**
 * ExecutionPlanAction is used to execution individual actions from the template actions in an ExecutionPlan
 */
@Entity
data class ExecutionPlanAction(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val actionName: String? = null,

    val isExecuted: Boolean = false,

    val isNotify: Boolean = false
)
