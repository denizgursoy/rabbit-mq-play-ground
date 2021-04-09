package org.example.fanout;

import org.example.ExchangeTypes;
import org.example.RabbitUtils;

public class FanoutExchangeCreator {
    public static final String FANOUT_EXCHANGE = "FANOUT_EXCHANGE";
    public static final String FANOUT_QUEUE_1 = "FANOUT_QUEUE";
    public static final String FANOUT_QUEUE_2 = "FANOUT_QUEUE_2";

    public static void main(String[] args) {
        RabbitUtils.getChannel().ifPresent(channel -> {
            try {
                channel.exchangeDeclare(FANOUT_EXCHANGE, ExchangeTypes.FANOUT.getType());
                channel.queueDeclare(FANOUT_QUEUE_1, true, false, false, null);
                channel.queueDeclare(FANOUT_QUEUE_2, true, false, false, null);
                channel.queueBind(FANOUT_QUEUE_1, FANOUT_EXCHANGE, "");
                channel.queueBind(FANOUT_QUEUE_2, FANOUT_EXCHANGE, "");
                channel.close();
            } catch (Exception e) {

            }
        });
    }
}
