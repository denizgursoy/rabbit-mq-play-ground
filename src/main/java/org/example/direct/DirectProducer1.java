package org.example.direct;

import org.example.RabbitUtils;

import java.nio.charset.StandardCharsets;

import static org.example.direct.DirectExchangeCreator.DIRECT_EXCHANGE;
import static org.example.direct.DirectExchangeCreator.DIRECT_ROUTING_1;

public class DirectProducer1 {
    public static void main(String[] args) {
        RabbitUtils.getChannel().ifPresent(channel -> {
            try {

                for (int i = 0; i < 40; i++) {
                    String message = "HELLO RABBIT" + i;
                    channel.basicPublish(DIRECT_EXCHANGE, DIRECT_ROUTING_1, null, message.getBytes(StandardCharsets.UTF_8));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
