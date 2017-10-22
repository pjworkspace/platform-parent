package com.framework.rabbitmq.response;

import java.io.Serializable;

/**
 * 消息响应
 * 
 * @author wangjie
 * 
 */
@SuppressWarnings("serial")
public class EventResponse implements Serializable {

	/* 消息处理结果 */
	private EventResults result;
	/* 消息响应信息 */
	private String responseMsg;
	/* 响应错误编号 */
	private String errorCode;
	/* 消息接收成功响应 */
	private Boolean receiveSuccess;

	private Object eventObj;

	public EventResponse() {
	}

	public EventResponse(Boolean receiveSuccess) {
		this.receiveSuccess = receiveSuccess;
	}

	public EventResponse(EventResults result, String responseMsg,
                         String errorCode, Boolean receiveSuccess) {
		this.result = result;
		this.responseMsg = responseMsg;
		this.errorCode = errorCode;
		this.receiveSuccess = receiveSuccess;
	}

	public EventResponse(EventResults result, String responseMsg,
                         String errorCode, Object eventObj) {
		this.result = result;
		this.responseMsg = responseMsg;
		this.errorCode = errorCode;
		this.receiveSuccess = false;
		this.eventObj = eventObj;
	}

	/** 消息响应信息 */
	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	/** 响应错误编号 */
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/** 消息接收成功响应 */
	public Boolean getReceiveSuccess() {
		return receiveSuccess;
	}

	public void setReceiveSuccess(Boolean receiveSuccess) {
		this.receiveSuccess = receiveSuccess;
	}

	/** 消息处理结果 */
	public EventResults getResult() {
		return result;
	}

	public void setResult(EventResults result) {
		this.result = result;
	}

	public Object getEventObj() {
		return eventObj;
	}

	public void setEventObj(Object eventObj) {
		this.eventObj = eventObj;
	}

	@Override
	public String toString() {
		return "EventResponse [result=" + result + ", responseMsg="
				+ responseMsg + ", errorCode=" + errorCode
				+ ", receiveSuccess=" + receiveSuccess + ", eventObj="
				+ eventObj + "]";
	}

}
