package com.kn.containershipment

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
@EnableRabbit
class ContainerShipmentApplication



fun main(args: Array<String>) {
	runApplication<ContainerShipmentApplication>(*args)
}