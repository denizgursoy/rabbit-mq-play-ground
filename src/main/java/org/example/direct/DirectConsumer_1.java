package org.example.direct;

import org.example.RabbitUtils;

import java.io.IOException;

public class DirectConsumer_1 {
    public static void main(String[] args) {

        RabbitUtils.getChannel().ifPresent(channel -> {
            try {
                channel.basicConsume(DirectBindingCreator.DIRECT_QUEUE_NAME, true, (consumerTag, message) -> {
                    String str = new String(message.getBody(), "UTF-8");
                    System.out.println("DirectConsumer_1 received");
                    System.out.println(" [x] Received '" + str + "'");
                }, consumerTag -> {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
}