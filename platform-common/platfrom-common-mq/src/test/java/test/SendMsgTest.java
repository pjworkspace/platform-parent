package test;

import com.framework.rabbitmq.broker.MessageRabbitMQBroker;
import com.framework.rabbitmq.event.*;
import com.framework.rabbitmq.response.EventResponse;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wangjie
 * @version 1.0.0
 * @Created with IntelliJ IDEA.
 * @Date: 2015/11/14 18:23
 */
public class SendMsgTest {
    static AtomicLong atomicLong = new AtomicLong(1);

    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executor.execute(new RunTask(atomicLong));
        }

    }

    private static void sendMsg(AtomicLong atomicLong) {
        MessageQueueEvent messageQueueEvent = new MessageQueueEvent();
        messageQueueEvent.setMessageQueueBusinessType(MessageQueueBusinessTypeEnum.register);
        messageQueueEvent.setMessageBodyTypeEnum(MessageBodyTypeEnum.json);
        messageQueueEvent.setMessageBody("test message body guojun " + atomicLong.getAndIncrement());
        EventObject<IEvent> event = new EventObject<IEvent>();
        event.setEventObject(messageQueueEvent);
        event.setEventSource("p2p-work");
        try {
            EventResponse response = MessageRabbitMQBroker.INSTANCE.post(event);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class RunTask implements Runnable {
        AtomicLong atomicLong;

        RunTask(AtomicLong atomicLong) {
            this.atomicLong = atomicLong;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1; i++) {
                sendMsg(atomicLong);
            }
        }
    }
}
