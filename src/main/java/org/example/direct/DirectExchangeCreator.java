package org.example.direct;

import org.example.ExchangeTypes;
import org.example.RabbitUtils;

public class DirectExchangeCreator {

    public final static String DIRECT_EXCHANGE = "my_direct_exchange";
    public final static String DIRECT_QUEUE_NAME = "my_queue";
    public final static String DIRECT_ROUTING_1 = "route_1";
    public final static String DIRECT_ROUTING_2 = "route_2";


    public static void main(String[] args) {
        RabbitUtils.getChannel().ifPresent(channel -> {
            try {
                channel.exchangeDeclare(DIRECT_EXCHANGE, ExchangeTypes.DIRECT.getType());
                channel.queueDeclare(DIRECT_QUEUE_NAME, true, false, false, null);
                channel.queueBind(DIRECT_QUEUE_NAME, DIRECT_EXCHANGE, DIRECT_ROUTING_2);
                channel.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


    }
}
