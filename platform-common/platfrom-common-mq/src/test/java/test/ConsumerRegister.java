package test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;

import java.io.IOException;

/**
 *
 * @Description 注册消费者
 * @author roc roc.fly@qq.com
 * @date Dec 29, 2016 1:36:25 PM
 */
public interface ConsumerRegister {
    public Consumer register(Channel channel) throws IOException;
}