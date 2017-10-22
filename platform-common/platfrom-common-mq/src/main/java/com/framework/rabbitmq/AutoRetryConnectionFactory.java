package com.framework.rabbitmq;

import com.framework.rabbitmq.util.PropertiesConfig;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public class AutoRetryConnectionFactory implements ShutdownListener {
	private static class SingletonHolder {
		private static final AutoRetryConnectionFactory INSTANCE = new AutoRetryConnectionFactory();
	}

	private static AtomicBoolean isConnected = new AtomicBoolean(false);
	private Connection conn = null;
	private Channel channel = null;

	private AutoRetryConnectionFactory() {
		init();
	}

	public static final AutoRetryConnectionFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public void closeChannelAndConnection() {

		if (channel != null && channel.isOpen()) {
			try {
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
		if (conn != null && conn.isOpen()) {
			try {
				conn.removeShutdownListener(this);
				conn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public Channel getChannel() {
		if (channel == null || !channel.isOpen()) {
			init();
		}
		return channel;
	}

	public void init() {
		synchronized (isConnected) {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setUsername(PropertiesConfig.INSTANCE.getProPerties("server.username"));
			factory.setPassword(PropertiesConfig.INSTANCE.getProPerties("server.password"));
//			factory.setVirtualHost(PropertiesConfig.INSTANCE.getProPerties("virtual.host"));
			try {
				// 集群模式,会按照数组顺序获取连接，一旦获取连接成功则就是这样机器的connection
				Address[] addrArr = new Address[] {
						new Address(PropertiesConfig.INSTANCE.getProPerties("server.ip"),Integer.parseInt(PropertiesConfig.INSTANCE.getProPerties("server.port"))), };
				conn = factory.newConnection(addrArr);
				conn.addShutdownListener(this);
				channel = conn.createChannel();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
	}

	@Override
	public void shutdownCompleted(ShutdownSignalException cause) {
		String exceptionMessage = cause.getMessage();
		System.out.println("client ; exceptionMessage: "
				.concat(exceptionMessage));
	}
}
