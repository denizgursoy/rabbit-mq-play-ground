package org.example.fanout;

import org.example.RabbitUtils;

import java.nio.charset.StandardCharsets;

public class FanoutProducer {
    public static void main(String[] args) {
        RabbitUtils.getChannel().ifPresent(channel -> {
            try {
                String message = "HELLO FANOUT QUEUES";
                channel.basicPublish(FanoutExchangeCreator.FANOUT_EXCHANGE, "", null, message.getBytes(StandardCharsets.UTF_8));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
