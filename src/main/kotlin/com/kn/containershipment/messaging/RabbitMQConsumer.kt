import com.rabbitmq.client.ConnectionFactory

class RabbitMQConsumer(private val queueName: String) {

    private val connectionFactory = ConnectionFactory().apply {
        host = "localhost" // replace with your RabbitMQ host
        port = 5672 // replace with your RabbitMQ port
        username = "guest" // replace with your RabbitMQ username
        password = "guest" // replace with your RabbitMQ password
    }

    fun start() {
        val connection = connectionFactory.newConnection()
        val channel = connection.createChannel()

        channel.queueDeclare(queueName, true, false, false, null)

        channel.basicConsume(queueName, true, { consumerTag, delivery ->
            val message = String(delivery.body)
            // process the message
        }, { consumerTag ->
            println("Consumer cancelled: $consumerTag")
        })
    }

    fun stop() {
        // TODO: implement stop method to close the RabbitMQ connection
    }
}
