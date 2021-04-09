package org.example.fanout;

import org.example.RabbitUtils;

public class FanoutConsumer1 {
    public static void main(String[] args) {

        RabbitUtils.getChannel().ifPresent(channel -> {
            try {
                channel.basicConsume(FanoutExchangeCreator.FANOUT_QUEUE_1, true, (consumerTag, message) -> {
                    String str = new String(message.getBody(), "UTF-8");
                    System.out.println("FanoutConsumer1 received");
                    System.out.println(" [x] Received '" + str + "'");
                }, consumerTag -> {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
