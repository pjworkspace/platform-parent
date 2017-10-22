package com.framework.rabbitmq.event;

/**
 * 消息发送格式
 */
public enum MessageBodyTypeEnum {
	object(1), json(2), string(3);

	private int value;

	MessageBodyTypeEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
