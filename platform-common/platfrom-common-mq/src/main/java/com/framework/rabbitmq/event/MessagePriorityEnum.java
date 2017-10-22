
package com.framework.rabbitmq.event;

public enum MessagePriorityEnum {
	MAX_PRIORITY(9), 
	NORMAL_PRIORITY(5), 
	MIN_PRIORITY(1);

	int value;

	private MessagePriorityEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
