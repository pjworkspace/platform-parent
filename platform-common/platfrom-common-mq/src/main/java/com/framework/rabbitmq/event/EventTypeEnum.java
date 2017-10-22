
package com.framework.rabbitmq.event;

public enum EventTypeEnum {
	
	messageQueue(1);

	int value;

	private EventTypeEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
