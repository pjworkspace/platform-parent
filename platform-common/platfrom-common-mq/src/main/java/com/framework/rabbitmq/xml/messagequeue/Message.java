package com.framework.rabbitmq.xml.messagequeue;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Message {
	private String businessType;
	private String exchange;
	private String exchangeType;
	private String description;
	private boolean trace = false;
	private List<MessageQueue> queuelist;
	private List<MessageExchange> exchangelist;

	@XmlAttribute
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	@XmlAttribute
	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	@XmlAttribute
	public String getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
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

	@XmlAttribute(name = "trace")
	public boolean isTrace() {
		return trace;
	}

	public void setTrace(boolean trace) {
		this.trace = trace;
	}
}
