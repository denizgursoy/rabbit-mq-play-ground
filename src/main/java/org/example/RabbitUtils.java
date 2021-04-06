package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Optional;

public class RabbitUtils {
    public static Optional<Channel> getChannel() {
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("localhost");

            Connection connection = connectionFactory.newConnection();
            return Optional.of(connection.createChannel());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
