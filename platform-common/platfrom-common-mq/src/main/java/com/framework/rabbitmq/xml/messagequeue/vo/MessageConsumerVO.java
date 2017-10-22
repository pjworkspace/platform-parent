package com.framework.rabbitmq.xml.messagequeue.vo;


import com.framework.rabbitmq.xml.messagequeue.ConsumerAttr;

import java.util.List;
import java.util.Map;

public class MessageConsumerVO {
	private String consumerID;
	private String consumerSource;
	private Map<String, ConsumerAttr> staticAttr;
	private Map<String, ConsumerAttr> dynamicAttr;
	private Boolean isOnline = false;
	private List<String> privateQueueNameList;
	private List<String> publicQueueNameList;

	public String getConsumerID() {
		return consumerID;
	}

	public void setConsumerID(String consumerID) {
		this.consumerID = consumerID;
	}

	public String getConsumerSource() {
		return consumerSource;
	}

	public void setConsumerSource(String consumerSource) {
		this.consumerSource = consumerSource;
	}

	public List<String> getPrivateQueueNameList() {
		return privateQueueNameList;
	}

	public void setPrivateQueueNameList(List<String> privateQueueNameList) {
		this.privateQueueNameList = privateQueueNameList;
	}

	public List<String> getPublicQueueNameList() {
		return publicQueueNameList;
	}

	public void setPublicQueueNameList(List<String> publicQueueNameList) {
		this.publicQueueNameList = publicQueueNameList;
	}

	public Boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

	public Map<String, ConsumerAttr> getStaticAttr() {
		return staticAttr;
	}

	public void setStaticAttr(Map<String, ConsumerAttr> staticAttr) {
		this.staticAttr = staticAttr;
	}

	public Map<String, ConsumerAttr> getDynamicAttr() {
		return dynamicAttr;
	}

	public void setDynamicAttr(Map<String, ConsumerAttr> dynamicAttr) {
		this.dynamicAttr = dynamicAttr;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MessageConsumerVO))
			return false;
		MessageConsumerVO other = (MessageConsumerVO) obj;
		if (consumerID != null) {
			if (consumerID.equals(other.consumerID)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return consumerID.hashCode();
	}
}
