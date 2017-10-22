package com.framework.rabbitmq.event;

import java.util.Date;

public class MessageQueueEvent implements IMessageQueueEvent {
    private static final long serialVersionUID = 5173896148165777491L;

    private Object messageBody; // 消息体
    private String destination;
    // 消息关键字
    private String routingKey = "#";
    // 消息类型
    private MessageQueueBusinessTypeEnum messageQueueBusinessType;
    // 是否需要持久化
//    private boolean isNeedPersistence = true;
    // broker confirm超时时间
    private long brokerConfirmTimeout = 0;
    //消息发送优先级
    MessagePriorityEnum priority  =  MessagePriorityEnum.NORMAL_PRIORITY;
    //消息发送过期时间
    long messageExpiresTime = 0;;

    private MessageBodyTypeEnum messageBodyTypeEnum = MessageBodyTypeEnum.json;
//    @Override
//    public boolean isNeedPersistence() {
//        return isNeedPersistence;
//    }
//
//    public void setNeedPersistence(boolean isNeedPersistence) {
//        this.isNeedPersistence = isNeedPersistence;
//    }


    @Override
    public Object getMessageBody() {
        return messageBody;
    }

    @Override
    public MessageQueueBusinessTypeEnum getMessageQueueBusinessType() {
        return messageQueueBusinessType;
    }

    @Override
    public MessageBodyTypeEnum getMessageBodyTypeEnum() {
        return messageBodyTypeEnum;
    }

    @Override
    public MessagePriorityEnum getMessagePriority() {
        return priority;
    }

    @Override
    public long getMessageExpiresTime() {
        return 0;
    }

    public void setMessagePriority(MessagePriorityEnum priority) {
        this.priority = priority;
    }
    @Override
    public EventTypeEnum getType() {
        return null;
    }

    @Override
    public String getSerialNum() {
        return null;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setMessageBody(Object messageBody) {
        this.messageBody = messageBody;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public void setMessageQueueBusinessType(MessageQueueBusinessTypeEnum messageQueueBusinessType) {
        this.messageQueueBusinessType = messageQueueBusinessType;
    }

//    public void setIsNeedPersistence(boolean isNeedPersistence) {
//        this.isNeedPersistence = isNeedPersistence;
//    }

    public long getBrokerConfirmTimeout() {
        return brokerConfirmTimeout;
    }

    public void setBrokerConfirmTimeout(long brokerConfirmTimeout) {
        this.brokerConfirmTimeout = brokerConfirmTimeout;
    }

    public void setMessageBodyTypeEnum(MessageBodyTypeEnum messageBodyTypeEnum) {
        this.messageBodyTypeEnum = messageBodyTypeEnum;
    }

    @Override
    public Date getTime() {
        return null;
    }
}
