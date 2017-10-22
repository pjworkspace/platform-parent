package test;

import com.framework.rabbitmq.util.PropertiesConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.util.concurrent.TimeoutException;

public class ClientReceiver {
    private final static String QUEUE_NAME = "test3";

    public static void main(String[] argv) throws java.io.IOException,
            java.lang.InterruptedException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(PropertiesConfig.INSTANCE.getProPerties("server.username"));
        factory.setPassword(PropertiesConfig.INSTANCE.getProPerties("server.password"));
        factory.setVirtualHost(PropertiesConfig.INSTANCE.getProPerties("virtual.host"));
        factory.setHost(PropertiesConfig.INSTANCE.getProPerties("server.ip"));
        factory.setPort(Integer.parseInt(PropertiesConfig.INSTANCE.getProPerties("server.port")));
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
//        channel.basicQos(1);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            Thread.sleep(1000*5);
            String message = new String(delivery.getBody());
//            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), true);
            System.out.println(" Received:'" + message + "'");
        }
    }
}
