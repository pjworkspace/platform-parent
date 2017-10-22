package com.framework.rabbitmq.xml.messagequeue.vo;

import java.util.List;

public class MessageConsumerSourceVO {
	private String name;
	private List<String> queueNameList;
	private List<String> exchangeNameList;
	private List<String> consumerIDList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getQueueNameList() {
		return queueNameList;
	}

	public void setQueueNameList(List<String> queueNameList) {
		this.queueNameList = queueNameList;
	}

	public List<String> getExchangeNameList() {
		return exchangeNameList;
	}

	public void setExchangeNameList(List<String> exchangeNameList) {
		this.exchangeNameList = exchangeNameList;
	}

	public List<String> getConsumerIDList() {
		return consumerIDList;
	}

	public void setConsumerIDList(List<String> consumerIDList) {
		this.consumerIDList = consumerIDList;
	}
}
