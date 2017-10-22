
package com.framework.rabbitmq.event;

public interface IMessageReceiveCondition {
	int getHandleThreadSize();
	
	long getReconnectionInterval();
	
}
