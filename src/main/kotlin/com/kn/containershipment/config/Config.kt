package com.kn.containershipment.config

import com.kn.containershipment.model.Action
import com.kn.containershipment.model.TemperatureRange
import com.kn.containershipment.model.PlanTemplate
import com.kn.containershipment.repository.ActionRepository
import com.kn.containershipment.repository.TemperatureRangeRepository
import com.kn.containershipment.repository.TemplateRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class Config {

    @Bean
    @Throws(Exception::class)
    fun run(templateRepository: TemplateRepository,
            actionRepository: ActionRepository,
            temperatureRangeRepository: TemperatureRangeRepository
    ): CommandLineRunner {
        return CommandLineRunner {
            val temperatureRange = TemperatureRange(id = 1, min = -20, max = -10)

            temperatureRangeRepository.save(temperatureRange)

            val action1 = Action(id = 1, name = "shipment is taken from customer")
            val action2 = Action(id = 2, name = "shipment is on the way")
            val action3 = Action(id = 3, name = "shipment is arrived to destination")
            val action4 = Action(id = 4, name = "shipment is handover to the destination target")

            actionRepository.saveAll(listOf(action1, action2, action3, action4))

            val defaultPlanTemplate = PlanTemplate(id = 999, name = "General Shipment Template", actions = listOf(action1, action2, action3, action4), temperatureRange = temperatureRange)

            templateRepository.save(defaultPlanTemplate)
            templateRepository.findAll().forEach(::print)
        }
    }

}