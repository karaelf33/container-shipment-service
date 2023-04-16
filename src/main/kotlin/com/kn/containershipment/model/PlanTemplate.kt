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
import org.hibernate.Hibernate

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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PlanTemplate

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name )"
    }
}

@Entity
@Table
@Data
data class Action(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val name: String? = null,
)