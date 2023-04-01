package com.kn.containershipment.repository

import com.kn.containershipment.model.*
import org.springframework.data.repository.CrudRepository

interface TemplateRepository : CrudRepository<PlanTemplate, Long>
interface ActionRepository : CrudRepository<Action, Long>
interface TemperatureRangeRepository : CrudRepository<TemperatureRange, Long>