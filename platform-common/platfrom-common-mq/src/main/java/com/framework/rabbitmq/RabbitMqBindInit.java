package com.framework.rabbitmq;

import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 * rabbitmq消息绑定
 * 
 * @author wangjie
 * 
 */
public class RabbitMqBindInit {
    String accountExchangeName = "account.exchange";
    String registerExchangeName = "register.exchange";
    String routingKeyCreateAccount = "createAccount";
    String routingKeyRegister = "register";
    String p2p1Queue = "p2p1.queue";
    String p2p2Queue = "p2p2.queue";
    String payQueue = "pay.queue";
    String exchangeType = "topic";//fanout、direct、topic、headers
	private Channel channel = null;
	public static final boolean durable = true; // 消息队列持久化

	private RabbitMqBindInit() {
		channel = AutoRetryConnectionFactory.getInstance().getChannel();
	}

	private static final RabbitMqBindInit INSTANCE = new RabbitMqBindInit();

	public static final RabbitMqBindInit getInstance() {
		return INSTANCE;
	}

	/**
	 * 删除queue和exchange
	 */
	public void removeQueueAndExchange() {
		try {
			channel.queueUnbind(p2p1Queue, accountExchangeName, routingKeyCreateAccount );
			channel.queueUnbind(p2p2Queue, accountExchangeName, routingKeyCreateAccount);
            channel.queueUnbind(payQueue, registerExchangeName, routingKeyRegister);
			channel.exchangeDelete(accountExchangeName);
			channel.queueDelete(p2p1Queue);
			channel.queueDelete(p2p2Queue);
            channel.queueDelete(payQueue);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 定义queue和exchange
	 */
	public void declareQueueAndExchange() {
		try {
			// 定义exchange
			channel.exchangeDeclare(accountExchangeName, exchangeType, durable);
            channel.exchangeDeclare(registerExchangeName, exchangeType, durable);
			// channel.exchangeDeclare("test.exchange", exchangeType, true);
			// 定义queue
			// Map<String, Object> map = new HashMap<String, Object>();
			// map.put("x-cancel-on-ha-failover", true);
			channel.queueDeclare(p2p1Queue, durable, false, false, null);
			channel.queueDeclare(p2p2Queue, durable, false, false, null);
            channel.queueDeclare(payQueue, durable, false, false, null);

			channel.queueBind(p2p1Queue, accountExchangeName, routingKeyCreateAccount);
			channel.queueBind(p2p2Queue, accountExchangeName, routingKeyCreateAccount);
            channel.queueBind(payQueue, registerExchangeName, routingKeyRegister);
			// channel.exchangeBind("test.exchange", exchangeName, routingKey);
			// channel.queueBind(queueName, "test.exchange", routingKey);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
	public static void main(String[] args) {
//		 RabbitMqBindInit.getInstance().removeQueueAndExchange();
		RabbitMqBindInit.getInstance().declareQueueAndExchange();

        System.out.println("init rabbitmq is ok !!!");
	}
}
