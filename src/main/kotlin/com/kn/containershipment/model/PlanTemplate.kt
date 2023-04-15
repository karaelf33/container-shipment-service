package com.kn.containershipment.model

import jakarta.persistence.Id
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.OneToMany
import jakarta.persistence.CascadeType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.FetchType
import lombok.Data

@Entity
@Table(name = "plan_template")
@Data
data class PlanTemplate(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val name: String? = null,

    @OneToMany(targetEntity = Action::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "pta_fk", referencedColumnName = "id")
    val actions: List<Action> = listOf(),

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true, fetch=FetchType.LAZY)
    @JoinColumn(name = "fk_temperature_range_id")
    val temperatureRange: TemperatureRange? = null
)

@Entity
@Table
@Data
data class Action(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val name: String? = null,
)