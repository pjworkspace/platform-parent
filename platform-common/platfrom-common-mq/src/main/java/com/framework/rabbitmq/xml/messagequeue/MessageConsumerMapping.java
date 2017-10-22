package com.framework.rabbitmq.xml.messagequeue;

import com.framework.rabbitmq.util.JaxbUtil;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;

@XmlRootElement(name = "message-consumer-mapping")
public class MessageConsumerMapping {
	private ConsumerSources consumerSources;
	private Messages messages;

	@XmlElement(name = "consumerSources")
	public ConsumerSources getConsumerSources() {
		return consumerSources;
	}

	public void setConsumerSources(ConsumerSources consumerSources) {
		this.consumerSources = consumerSources;
	}

	@XmlElement(name = "messages")
	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public static void main(String[] args) {
		try {
			InputStream is = MessageConsumerMapping.class
					.getResourceAsStream("/messagequeue.xml");
			MessageConsumerMapping mcp = (MessageConsumerMapping) JaxbUtil
					.xmlToObj(is, MessageConsumerMapping.class);
			for (Message msg : mcp.getMessages().getMessageList()) {
				System.out.print(msg.getBusinessType());
				if (msg.getQueuelist() != null) {
					for (MessageQueue mq : msg.getQueuelist()) {
						System.out.print("   " + mq.getQueueName() + "  #"
								+ mq.getRoutingkey() + "#");
					}
				}
				System.out.println();
			}
			
			for (ConsumerSource cs : mcp.getConsumerSources()
					.getConsumerSourceList()) {
				System.out.print(cs.getDescription());
				if (cs.getQueuelist() != null) {
					for (MessageQueue mq : cs.getQueuelist()) {
						System.out.print("   " + mq.getQueueName());
					}
				}
				System.out.println();
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
