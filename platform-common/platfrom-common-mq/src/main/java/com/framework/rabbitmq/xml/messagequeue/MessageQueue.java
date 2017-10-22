package com.framework.rabbitmq.xml.messagequeue;

import javax.xml.bind.annotation.XmlAttribute;

public class MessageQueue {
	private String queueName;
	private boolean mirror = false;
	private int mirrorNumber;
	private String routingkey;
	private String mirrorNodes;

	@XmlAttribute
	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	@XmlAttribute
	public String getRoutingkey() {
		return routingkey;
	}

	public void setRoutingkey(String routingkey) {
		this.routingkey = routingkey;
	}

	@XmlAttribute
	public boolean isMirror() {
		return mirror;
	}

	public void setMirror(boolean mirror) {
		this.mirror = mirror;
	}

	@XmlAttribute
	public int getMirrorNumber() {
		return mirrorNumber;
	}

	public void setMirrorNumber(int mirrorNumber) {
		this.mirrorNumber = mirrorNumber;
	}

	@XmlAttribute
	public String getMirrorNodes() {
		return mirrorNodes;
	}

	public void setMirrorNodes(String mirrorNodes) {
		this.mirrorNodes = mirrorNodes;
	}
}
