package test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 测试 demo
 *
 */
public class RabbitMQDelayQueueTest {

    public static void main(String[] args) throws IOException, TimeoutException {
        delayQueue();
    }

    public static void delayQueue() throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        Address address = new Address("192.168.1.101", 5672);
        Connection connection = factory.newConnection(new Address[] { address });

        RabbitMQDelayQueue delayQueue = new RabbitMQDelayQueue.Builder().setConnection(connection).setPerDelayQueueMessageTTL(15, TimeUnit.SECONDS).setDelayExchangeName("delay_exchange_roc").setDelayQueueName("delay_queue_roc").setDelayRoutingKeyName("delay_routing_key_roc").setConsumerRegister(
                new ConsumerRegister() {
            @Override
            public Consumer register(Channel channel) throws IOException {
                return new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
                        long deliveryTag = envelope.getDeliveryTag();
                        String exchange = envelope.getExchange();
                        String routingKey = envelope.getRoutingKey();
                        // TODO do something
                        String content = new String(body, Charset.forName("utf-8"));
                        System.out.println("receive message --- > " + content);

                        Map<String, Object> headers = properties.getHeaders();
                        if (headers != null) {
                            List<Map<String, Object>> xDeath = (List<Map<String, Object>>) headers.get("x-death");
                            System.out.println("xDeath--- > " + xDeath);
                            if (xDeath != null && !xDeath.isEmpty()) {
                                Map<String, Object> entrys = xDeath.get(0);
                            }
                        }
                        // 消息拒收
                        // if(do something) 消息重新入队
                        getChannel().basicReject(deliveryTag, false);
                        // else 消息应答
                        // getChannel().basicAck(deliveryTag, false);
                    }
                };
            }
        }).build();

        delayQueue.put("{\"name\" : \"i am roc!!\"}\"".getBytes("UTF-8"), 3, TimeUnit.SECONDS);

    }
}