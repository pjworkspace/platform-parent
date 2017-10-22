package com.framework.rabbitmq.xml.messagequeue.vo;

import java.util.List;

public class MessageExchangeVO {
	private String exchangeName;
	private String type;
	private boolean createTempChildQueue = false;
	private List<MessageBindingVO> queueBindingList;
	private List<MessageBindingVO> exchangeBindingList;
	private boolean mirror = false;
	private String mirrorNodes;
	private int mirrorNumber;
	
	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public List<MessageBindingVO> getQueueBindingList() {
		return queueBindingList;
	}

	public void setQueueBindingList(List<MessageBindingVO> queueBindingList) {
		this.queueBindingList = queueBindingList;
	}

	public List<MessageBindingVO> getExchangeBindingList() {
		return exchangeBindingList;
	}

	public void setExchangeBindingList(
			List<MessageBindingVO> exchangeBindingList) {
		this.exchangeBindingList = exchangeBindingList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isCreateTempChildQueue() {
		return createTempChildQueue;
	}

	public void setCreateTempChildQueue(boolean createTempChildQueue) {
		this.createTempChildQueue = createTempChildQueue;
	}

	public boolean isMirror() {
		return mirror;
	}

	public void setMirror(boolean mirror) {
		this.mirror = mirror;
	}

	public String getMirrorNodes() {
		return mirrorNodes;
	}

	public void setMirrorNodes(String mirrorNodes) {
		this.mirrorNodes = mirrorNodes;
	}

	public int getMirrorNumber() {
		return mirrorNumber;
	}

	public void setMirrorNumber(int mirrorNumber) {
		this.mirrorNumber = mirrorNumber;
	}
}
