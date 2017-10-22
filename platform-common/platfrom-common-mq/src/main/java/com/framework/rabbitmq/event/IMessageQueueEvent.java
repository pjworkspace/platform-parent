package com.framework.rabbitmq.event;

public interface IMessageQueueEvent extends IEvent {

//	boolean isNeedPersistence();

	Object getMessageBody();

	MessageQueueBusinessTypeEnum getMessageQueueBusinessType();
	
	MessageBodyTypeEnum getMessageBodyTypeEnum();

    MessagePriorityEnum getMessagePriority();

    long  getMessageExpiresTime();
}