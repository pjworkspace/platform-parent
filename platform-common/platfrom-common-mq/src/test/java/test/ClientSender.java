package test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.framework.rabbitmq.util.PropertiesConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *
 */
public class ClientSender {
    private final static String QUEUE_NAME = "test123";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(PropertiesConfig.INSTANCE.getProPerties("server.username"));
        factory.setPassword(PropertiesConfig.INSTANCE.getProPerties("server.password"));
//        factory.setVirtualHost(PropertiesConfig.INSTANCE.getProPerties("virtual.host"));
        factory.setHost(PropertiesConfig.INSTANCE.getProPerties("server.ip"));
        factory.setPort(Integer.parseInt(PropertiesConfig.INSTANCE.getProPerties("server.port")));
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World，OK";
        channel.basicPublish("ex1", QUEUE_NAME, null, message.getBytes());

        Channel channel1 = connection.createChannel();
//        channel1.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message1 = "嗨，你好！";

        channel1.basicPublish("ex1", QUEUE_NAME, null, message1.getBytes());

        System.out.println("  Sent: '" + message + "'");
//        channel.close();
//        connection.close();
    }
}
