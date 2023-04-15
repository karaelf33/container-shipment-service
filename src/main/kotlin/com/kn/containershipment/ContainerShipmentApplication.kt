package com.kn.containershipment

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@EnableRabbit
@ComponentScan(basePackages = ["com.kn.containershipment"])
class ContainerShipmentApplication




fun main(args: Array<String>) {
	runApplication<ContainerShipmentApplication>(*args)
}