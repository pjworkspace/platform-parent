package com.framework.rabbitmq.xml.messagequeue;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Messages {
	private List<Message> messageList;

	@XmlElement(name = "message")
	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
}
