package org.example.direct;

import org.example.RabbitUtils;

import java.nio.charset.StandardCharsets;

import static org.example.direct.DirectBindingCreator.DIRECT_EXCHANGE;
import static org.example.direct.DirectBindingCreator.DIRECT_ROUTING_2;

public class DirectProducer2 {
    public static void main(String[] args) {
        RabbitUtils.getChannel().ifPresent(channel -> {
            try {

                for (int i = 0; i < 40; i++) {
                    String message = "GOOD BYE RABBIT" + i;
                    channel.basicPublish(DIRECT_EXCHANGE, DIRECT_ROUTING_2, null, message.getBytes(StandardCharsets.UTF_8));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
