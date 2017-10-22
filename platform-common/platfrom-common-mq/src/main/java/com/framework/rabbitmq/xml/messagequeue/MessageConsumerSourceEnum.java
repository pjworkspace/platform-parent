package com.framework.rabbitmq.xml.messagequeue;

public enum MessageConsumerSourceEnum {
    /**
     * p2p平台
     */
    p2pWork("p2p"),
    /**
     * 支付平台
     */
    payWork("pay"),
    ;

    private String consumerSource;

    private MessageConsumerSourceEnum(String consumerSource) {
        this.consumerSource = consumerSource;
    }

    public String getConsumerSource() {
        return consumerSource;
    }
}
