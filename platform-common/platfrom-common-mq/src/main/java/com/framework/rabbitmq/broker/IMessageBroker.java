package com.framework.rabbitmq.broker;

import com.framework.rabbitmq.event.EventObject;
import com.framework.rabbitmq.event.IEvent;
import com.framework.rabbitmq.response.EventResponse;

/**
 * @author wangjie
 * @version 1.0.0
 * @Created with IntelliJ IDEA.
 * @Date: 2015/11/14 17:26
 */
public interface IMessageBroker {
    EventResponse post(EventObject<IEvent> eventObj);
}
