package com.framework.rabbitmq.broker;

import com.framework.rabbitmq.AutoRetryConnectionFactory;
import com.framework.rabbitmq.ExchangeQueueMappingManager;
import com.framework.rabbitmq.event.*;
import com.framework.rabbitmq.response.EventResponse;
import com.framework.rabbitmq.response.EventResults;
import com.framework.rabbitmq.util.KryoUtil;
import com.framework.rabbitmq.xml.messagequeue.vo.MessageVO;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 * @author wangjie
 * @version 1.0.0
 * @Created with IntelliJ IDEA.
 * @Date: 2015/11/14 17:26
 */
public enum MessageRabbitMQBroker implements IMessageBroker {

    INSTANCE;

    @Override
    public EventResponse post(EventObject<IEvent> eventObj) {
        if (eventObj == null) {
            return new EventResponse(EventResults.failure,
                    "event object cannot be null", MessageCode.ARG_EXCEPTION,
                    Boolean.FALSE);
        }
        if (!(eventObj.getEventObject() instanceof MessageQueueEvent)) {
            return new EventResponse(EventResults.failure,
                    "invalid message queue event",
                    MessageCode.ARG_EXCEPTION, Boolean.FALSE);
        }
        IMessageQueueEvent messageQueueEvent = (IMessageQueueEvent) eventObj.getEventObject();
        Object messageBody = messageQueueEvent.getMessageBody();
        Channel channel = AutoRetryConnectionFactory
                .getInstance().getChannel();
        byte[] message = messageBody.toString().getBytes();
//        if(MessageBodyTypeEnum.object == messageQueueEvent.getMessageBodyTypeEnum()){
//            message = KryoUtil
//                    .serailToByte(messageBody);
//        }else{
//            message = messageBody.toString().getBytes();
//        }
        MessageVO messageVO = ExchangeQueueMappingManager.getInstance().getMessageByBusinessType(messageQueueEvent.getMessageQueueBusinessType().getBusinessType());
        if (messageVO == null) {
            return new EventResponse(EventResults.failure,
                    "exchange not exist",
                    MessageCode.EXCHANGE_NOT_EXIST, Boolean.FALSE);
        }
        String exchangeName = messageVO.getExchange();
        String routingKey = messageVO.getRoutingKey();
        //将队列设置为持久化之后，还需要将消息也设为可持久化的，MessageProperties.PERSISTENT_TEXT_PLAIN
        try {
            if (message != null) {
                //confirmack
//                channel.confirmSelect();
                channel
                        .basicPublish(exchangeName,
                                routingKey, generateBuilder(messageQueueEvent).build(), KryoUtil.serailToByte(messageBody) );

            }
//            channel.waitForConfirms();
        } catch (IOException e) {
            e.printStackTrace();
            return new EventResponse(EventResults.failure,
                    e.getMessage(),
                    MessageCode.SYSTEM_EXCEPTION, Boolean.FALSE);
        } finally {
        }
        return new EventResponse(EventResults.success,
                "SUCCESS",
                "", Boolean.TRUE);
    }

    public AMQP.BasicProperties.Builder generateBuilder(
            IMessageQueueEvent messageQueueEvent) throws IOException {
        AMQP.BasicProperties props = new AMQP.BasicProperties();
        AMQP.BasicProperties.Builder builder = props.builder();
        builder.contentType("text/plain");
        builder.contentEncoding("UTF-8");
        builder.priority(messageQueueEvent.getMessagePriority().getValue());
        if (messageQueueEvent.getMessageExpiresTime() > 0) {
            builder.expiration(messageQueueEvent.getMessageExpiresTime() + "");
        }
        return builder;
    }
}
