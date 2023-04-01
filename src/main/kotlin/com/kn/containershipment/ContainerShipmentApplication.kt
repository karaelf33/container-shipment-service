package com.kn.containershipment

import com.rabbitmq.client.AMQP
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@EnableRabbit
@ComponentScan(basePackages = ["com.kn"])
class ContainerShipmentApplication



fun main() {
	val factory = ConnectionFactory()
	factory.host = "localhost"
	factory.username = "yusufbestas"
	factory.password = "1234"

	val connection = factory.newConnection()
	val channel = connection.createChannel()

	val exchangeName = "amq.fanout"
	val queueName = "shipment"
	val routingKey = "shipment"

	channel.exchangeDeclare(exchangeName, "fanout", true)
	channel.queueDeclare(queueName, true, false, false, null)
	channel.queueBind(queueName, exchangeName, routingKey)

	val consumer = object : DefaultConsumer(channel) {
		override fun handleDelivery(
			consumerTag: String?,
			envelope: Envelope?,
			properties: AMQP.BasicProperties?,
			body: ByteArray?
		) {
			val message = body?.let { String(it, charset("UTF-8")) }
			println("Received message: $message")
		}
	}

	channel.basicConsume(queueName, true, consumer)
}