
package com.framework.rabbitmq.event;

public final class MessageCode {
	/**
	 * 消息为空
	 */
	public static final String MESSAGE_IS_EMPTY = "1001";
	/**
	 * 参数异常
	 */
	public static final String ARG_EXCEPTION = "1002";
	/**
	 * 消息类型无法识别
	 */
	public static final String MESSAGE_TYPE_CAN_NOT_IDENTIFY = "1003";
	/**
	 * 系统错误
	 */
	public static final String SYSTEM_EXCEPTION = "1004";

	/**
	 * 连接失败
	 */
	public static final String CONNECTION_FAILURE = "1007";
	/**
	 * 消息的业务类型为空
	 */
	public static final String MESSAGE_BUSINESS_TYPE_EMPTY = "1102";
	
	/**
	 * 消费者的消费类型为空
	 */
	public static final String CONSUMER_SOURCE_TYPE_EMPTY = "1103";
	/**
	 * 等待客户端反馈超时
	 */
	public static final String WAIT_CONSUMER_FEEDBACK_TIMEOUT = "1107";
	
	/**
	 * 处理消费端的反馈处理对象为空
	 */
	public static final String CONSUMER_FEEDBACK_HANDLER_EMPTY = "1108";
	
	/**
	 * 远程调用处理失败
	 */
	public static final String RPC_HANDLE_FAILURE = "1109";
	
	/**
	 * Queue  不存在
	 */
	public static final String QUEUE_NOT_EXIST = "1110";
	
	/**
	 * Exchange 不存在
	 */
	public static final String EXCHANGE_NOT_EXIST = "1111";
	
	
	
	
	
	
	/**
	 * 消息中间件配置信息的zookeeper服务器连不上
	 */
	public static final String ZOOKEEPER_CONNECTION_FAILURE = "1201";
}
