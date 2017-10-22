package com.framework.rabbitmq.xml.messagequeue;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class ConsumerSources {
	private List<ConsumerSource> consumerSourceList;

	@XmlElement(name = "consumerSource")
	public List<ConsumerSource> getConsumerSourceList() {
		return consumerSourceList;
	}

	public void setConsumerSourceList(List<ConsumerSource> consumerSourceList) {
		this.consumerSourceList = consumerSourceList;
	}
}
