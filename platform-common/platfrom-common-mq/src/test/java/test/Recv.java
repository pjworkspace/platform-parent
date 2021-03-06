package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {

    // 队列名称
    private final static String QUEUE_NAME = "delay_queue";
    private final static String EXCHANGE_NAME="delay_exchange";

    public static void main(String[] argv) throws Exception,
            java.lang.InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.1.101");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        channel.queueDeclare(QUEUE_NAME, true,false,false,null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        channel.basicConsume(QUEUE_NAME, true, queueingConsumer);
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            System.out.println("****************WAIT***************");
            while(true){
                QueueingConsumer.Delivery delivery = queueingConsumer
                        .nextDelivery(); //

                String message = (new String(delivery.getBody()));
                System.out.println("message:"+message);
                System.out.println("now:\t"+sf.format(new Date()));
            }

        } catch (Exception exception) {
            exception.printStackTrace();

        }

    }
}