package com.framework.rabbitmq.xml.messagequeue;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class ConsumerSource {
	private String name;
	private String description;
	private List<MessageQueue> queuelist;
    private List<MessageExchange>  exchangelist;
	
	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "queue")
	public List<MessageQueue> getQueuelist() {
		return queuelist;
	}

	public void setQueuelist(List<MessageQueue> queuelist) {
		this.queuelist = queuelist;
	}
	@XmlElement(name = "exchange")
	public List<MessageExchange> getExchangelist() {
		return exchangelist;
	}

	public void setExchangelist(List<MessageExchange> exchangelist) {
		this.exchangelist = exchangelist;
	}
}
