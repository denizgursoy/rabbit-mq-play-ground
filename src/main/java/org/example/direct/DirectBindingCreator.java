package org.example.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.example.ExchangeTypes;

import java.nio.charset.StandardCharsets;

public class DirectBindingCreator {

    public final static String DIRECT_EXCHANGE = "my_direct_exchange";
    public final static String DIRECT_QUEUE_NAME = "my_queue";


    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");


        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(DIRECT_EXCHANGE, ExchangeTypes.DIRECT.getType());

        channel.queueDeclare(DIRECT_QUEUE_NAME, true, false, false, null);
        channel.queueBind(DIRECT_QUEUE_NAME, DIRECT_EXCHANGE, "");

        String message = "HELLO RABBIT";

        channel.basicPublish(DirectBindingCreator.DIRECT_EXCHANGE, "", null, message.getBytes(StandardCharsets.UTF_8));


    }
}
