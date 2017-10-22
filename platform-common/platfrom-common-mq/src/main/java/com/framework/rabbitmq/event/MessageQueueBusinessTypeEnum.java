package com.framework.rabbitmq.event;

public enum MessageQueueBusinessTypeEnum {
    account("createAccount"),
    register("register"),

    ;

	private String businessType;

	private MessageQueueBusinessTypeEnum(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessType() {
		return businessType;
	}
}
