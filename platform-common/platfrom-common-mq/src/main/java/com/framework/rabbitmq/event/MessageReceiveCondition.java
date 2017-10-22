package com.framework.rabbitmq.event;

public class MessageReceiveCondition implements IMessageReceiveCondition{
	private int handleThreadSize = 1;
	private long reconnectionInterval = 3000;

	public int getHandleThreadSize() {
		return handleThreadSize;
	}

	public void setHandleThreadSize(int handleThreadSize) {
		this.handleThreadSize = handleThreadSize;
	}

	public long getReconnectionInterval() {
		return reconnectionInterval;
	}

	public void setReconnectionInterval(long reconnectionInterval) {
		this.reconnectionInterval = reconnectionInterval;
	}

}
