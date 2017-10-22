package test;

import com.framework.rabbitmq.acceptor.MessageQueueEventAcceptor;
import com.framework.rabbitmq.xml.messagequeue.MessageConsumerSourceEnum;

import java.util.Observable;
import java.util.Observer;

public class ReceiveMsgTest implements Observer {

    public static void main(String[] args) {
        MessageQueueEventAcceptor.getInstance().addObserver(
                new ReceiveMsgTest(), MessageConsumerSourceEnum.p2pWork);
    }

    @Override
    public void update(Observable o, Object arg) {
//        test unacked msg
//        if(arg.toString().endsWith("5")){
//            throw new RuntimeException("by RuntimeException");
//        }
        System.out.println("paywork;接收消息：" + arg);
    }
}
