
package com.framework.rabbitmq.event;

import java.io.Serializable;
public final class EventObject<T extends IEvent> implements Serializable {

	private T eventObject;// 消息体
//	private EventTypeEnum eventType;// 消息类型
	private String eventSource;// 消息源信息

    public T getEventObject() {
        return eventObject;
    }

    public void setEventObject(T eventObject) {
        this.eventObject = eventObject;
    }

//    public EventTypeEnum getEventType() {
//        return eventType;
//    }
//
//    public void setEventType(EventTypeEnum eventType) {
//        this.eventType = eventType;
//    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

}
