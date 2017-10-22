package com.framework.rabbitmq.acceptor;

import com.framework.rabbitmq.AutoRetryConnectionFactory;
import com.framework.rabbitmq.ExchangeQueueMappingManager;
import com.framework.rabbitmq.util.KryoUtil;
import com.framework.rabbitmq.xml.messagequeue.MessageConsumerSourceEnum;
import com.framework.rabbitmq.xml.messagequeue.vo.MessageConsumerSourceVO;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;
import java.lang.Thread.State;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class MessageQueueEventAcceptor extends Observable {

    private static MessageConsumerSourceEnum messageConsumerSourceEnum;


    private Vector<Observer> vector = new Vector<Observer>();
    private static final MessageQueueEventAcceptor INSTANCE = new MessageQueueEventAcceptor();


    public static final MessageQueueEventAcceptor getInstance() {
        return INSTANCE;
    }

    public synchronized void addObserver(Observer o, MessageConsumerSourceEnum consumerSourceEnum) {
        this.messageConsumerSourceEnum = consumerSourceEnum;
        addObserver(o);
    }

    @Override
    public synchronized void addObserver(Observer o) {
        vector.add(o);
        Thread t = new Thread(new AcceptorMessageQueueRunner());
        if (t.getState() == State.NEW) {
            t.start();
        }
    }

    public void messageArrived(Object message) {
        for (Observer o : vector) {
            o.update(this, message);
        }
    }

    private static class AcceptorMessageQueueRunner implements Runnable {

        public void run() {
            Channel channel = AutoRetryConnectionFactory.getInstance()
                    .getChannel();
            try {
                QueueingConsumer consumer = new QueueingConsumer(channel);
                // 默认是需要consumer收到消息后才进行ack
                boolean autoAck = false;
                //channel执行basicConsume方法时autoAck为false，这就意味着接受者在收到消息后需要主动通知RabbitMQ才能将该消息从队列中删除，否则该在接收者跟MQ连接没断的情况下，消息将会变为untracked状态，一旦接收者断开连接，消息重新变为ready状态。
                if (messageConsumerSourceEnum != null) {
                    MessageConsumerSourceVO consumerSourceVO = ExchangeQueueMappingManager.getInstance().getConsumerSource(messageConsumerSourceEnum.getConsumerSource());
                    channel.basicConsume(consumerSourceVO.getQueueNameList().get(0), autoAck, consumer);
                    // 循环监听消息
                    for (; ; ) {
                        QueueingConsumer.Delivery delivery = consumer
                                .nextDelivery(3000);
                        if (delivery == null) {
                            continue;
                        }
                        byte[] message = delivery.getBody();
                        try {
                            MessageQueueEventAcceptor.getInstance().messageArrived(
                                    KryoUtil.deserialToObj(message));
                            // 发送消息后标志为收到成功
                            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),
                                    false);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ShutdownSignalException e) {
                AutoRetryConnectionFactory.getInstance().init();
                e.printStackTrace();
            } catch (ConsumerCancelledException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                AutoRetryConnectionFactory.getInstance()
                        .closeChannelAndConnection();
            }
        }
    }
}
