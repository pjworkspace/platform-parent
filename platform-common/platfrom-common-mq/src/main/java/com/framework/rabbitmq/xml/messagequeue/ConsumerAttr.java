package com.framework.rabbitmq.xml.messagequeue;

import java.io.Serializable;
import java.util.Date;

public class ConsumerAttr implements Serializable{
    String  attributeValue;
    Date    lastModifiedTime;
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	
}
