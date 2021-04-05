package org.example.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectConsumer {
    public static void main(String[] args) throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.basicConsume(DirectBindingCreator.DIRECT_QUEUE_NAME, true, (consumerTag, message) -> {
            String str = new String(message.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + str + "'");
        }, consumerTag -> {
        });
    }
}
