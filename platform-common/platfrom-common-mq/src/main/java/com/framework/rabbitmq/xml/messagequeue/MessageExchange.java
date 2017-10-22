package com.framework.rabbitmq.xml.messagequeue;

import javax.xml.bind.annotation.XmlAttribute;

public class MessageExchange {
	private String exchangeName;
	private String routingkey;
	private boolean createTempChildQueue = false;
	private boolean mirror = false;
	private String mirrorNodes;
	private int mirrorNumber;

	@XmlAttribute
	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	@XmlAttribute
	public String getRoutingkey() {
		return routingkey;
	}

	public void setRoutingkey(String routingkey) {
		this.routingkey = routingkey;
	}

	@XmlAttribute
	public boolean isCreateTempChildQueue() {
		return createTempChildQueue;
	}

	public void setCreateTempChildQueue(boolean createTempChildQueue) {
		this.createTempChildQueue = createTempChildQueue;
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
