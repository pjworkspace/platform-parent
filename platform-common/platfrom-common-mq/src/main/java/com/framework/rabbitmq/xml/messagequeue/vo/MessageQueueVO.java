package com.framework.rabbitmq.xml.messagequeue.vo;

import java.util.List;

public class MessageQueueVO {
	private String queueName;
	private boolean mirror = false;
	private String mirrorNodes;
	private int mirrorNumber;
	private List<String> messageConsumerList;

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public List<String> getMessageConsumerList() {
		return messageConsumerList;
	}

	public void setMessageConsumerList(List<String> messageConsumerList) {
		this.messageConsumerList = messageConsumerList;
	}

	public boolean isMirror() {
		return mirror;
	}

	public void setMirror(boolean mirror) {
		this.mirror = mirror;
	}

	public int getMirrorNumber() {
		return mirrorNumber;
	}

	public void setMirrorNumber(int mirrorNumber) {
		this.mirrorNumber = mirrorNumber;
	}

	public String getMirrorNodes() {
		return mirrorNodes;
	}

	public void setMirrorNodes(String mirrorNodes) {
		this.mirrorNodes = mirrorNodes;
	}
}
