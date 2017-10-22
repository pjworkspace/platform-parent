package com.framework.rabbitmq;

import com.framework.rabbitmq.util.JaxbUtil;
import com.framework.rabbitmq.xml.messagequeue.*;
import com.framework.rabbitmq.xml.messagequeue.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 与messagequeue.xml文件的映射类
 * 
 * @author wangjie
 * 
 */
public class ExchangeQueueMappingManager {
	private static Logger logger = LoggerFactory
			.getLogger(ExchangeQueueMappingManager.class);

	private static Map<String, ConsumerSource> ConsumerSourceXmlMap = new HashMap<String, ConsumerSource>();
    private static Map<String, MessageConsumerSourceVO> messageConsumerSourceVOMap = new HashMap<String, MessageConsumerSourceVO>();
    private static Map<String, MessageVO> messageVOMap = new HashMap<String, MessageVO>();
    private static Map<String, MessageExchangeVO> messageExchangeVOMap = new HashMap<String, MessageExchangeVO>();
    private static Map<String, MessageQueueVO> messageQueueVOMap = new HashMap<String, MessageQueueVO>();

	private static ExchangeQueueMappingManager instance = new ExchangeQueueMappingManager();

	private ExchangeQueueMappingManager() {
		init();
	}

	private void init() {
		try {
			MessageConsumerMapping mcp = (MessageConsumerMapping) JaxbUtil
					.xmlToObj(ExchangeQueueMappingManager.class
                                    .getResourceAsStream("/messagequeue.xml"),
                            MessageConsumerMapping.class);
			for (ConsumerSource cs : mcp.getConsumerSources()
					.getConsumerSourceList()) {
				ConsumerSourceXmlMap.put(cs.getName(), cs);

				storeConsumerSourceVO(cs);
			}

			for (Message msg : mcp.getMessages().getMessageList()) {
				storeMessageVO(msg);
			}
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private void storeMessageVO(Message msg) {
		MessageVO message = new MessageVO();
		message.setBusinessType(msg.getBusinessType());
		message.setExchange(msg.getExchange());
		message.setRoutingKey(msg.getBusinessType());
		message.setTrace(msg.isTrace());
		messageVOMap.put(msg.getBusinessType(), message);

		storeExchangeVoForMessage(msg);
	}

	private void storeConsumerSourceVO(ConsumerSource cs) {
		MessageConsumerSourceVO messageConsumerSourceVO = new MessageConsumerSourceVO();
		messageConsumerSourceVO.setName(cs.getName());
		if (cs.getExchangelist() != null) {
			List<String> exchangeNames = new ArrayList<String>();
			for (MessageExchange me : cs.getExchangelist()) {
				exchangeNames.add(me.getExchangeName());

				// 保存接收端的exchange
				storeExchangeVO(me);
			}
			messageConsumerSourceVO.setExchangeNameList(exchangeNames);
		}
		if (cs.getQueuelist() != null) {
			List<String> queueNames = new ArrayList<String>();
			for (MessageQueue mq : cs.getQueuelist()) {
				queueNames.add(mq.getQueueName());

				// 保存接收端的queue
				storeQueueVO(mq);
			}
			messageConsumerSourceVO.setQueueNameList(queueNames);
		}
		messageConsumerSourceVOMap.put(cs.getName(), messageConsumerSourceVO);
	}

	/**
	 * 存储message节点的属性中的exchange信息，并保存与子节点的绑定关系, 子节点包括queue和exchange
	 */
	private void storeExchangeVoForMessage(Message msg) {
		MessageExchangeVO messageExchangeVO = messageExchangeVOMap.get(msg
				.getExchange());
		if (messageExchangeVO == null) {
			messageExchangeVO = new MessageExchangeVO();
			messageExchangeVO.setExchangeName(msg.getExchange());
			messageExchangeVO.setType(msg.getExchangeType());
		}
		if (msg.getExchangelist() != null) {
			List<MessageBindingVO> exchangeBindings = messageExchangeVO
					.getExchangeBindingList();
			// 多个类型的message可能公用一个exchange，所以这里防止循环时被覆盖，做一下非空判断
			if (exchangeBindings == null) {
				exchangeBindings = new ArrayList<MessageBindingVO>();
			}
			// 这个exchange 是 message 节点中的子节点，不是message节点的属性
			for (MessageExchange me : msg.getExchangelist()) {
				MessageBindingVO ExchangeBinding = new MessageBindingVO();
				ExchangeBinding.setSourceName(msg.getExchange());
				ExchangeBinding.setDestinationName(me.getExchangeName());
				ExchangeBinding.setRoutingKey(me.getRoutingkey());
				exchangeBindings.add(ExchangeBinding);
			}
			messageExchangeVO.setExchangeBindingList(exchangeBindings);
		}
		if (msg.getQueuelist() != null) {
			List<MessageBindingVO> queueBindings = messageExchangeVO
					.getQueueBindingList();
			if (queueBindings == null) {
				queueBindings = new ArrayList<MessageBindingVO>();
			}
			for (MessageQueue mq : msg.getQueuelist()) {
				MessageBindingVO queueBinding = new MessageBindingVO();
				queueBinding.setSourceName(msg.getExchange());
				queueBinding.setDestinationName(mq.getQueueName());
				queueBinding.setRoutingKey(mq.getRoutingkey());
				queueBindings.add(queueBinding);
			}
			messageExchangeVO.setQueueBindingList(queueBindings);
		}
		messageExchangeVOMap.put(msg.getExchange(), messageExchangeVO);
	}

	private void storeQueueVO(MessageQueue mq) {
		MessageQueueVO queue = new MessageQueueVO();
		queue.setQueueName(mq.getQueueName());
		queue.setMirror(mq.isMirror());
		queue.setMirrorNumber(mq.getMirrorNumber());
		queue.setMirrorNodes(mq.getMirrorNodes());
		messageQueueVOMap.put(mq.getQueueName(), queue);
	}

	private void storeExchangeVO(MessageExchange me) {
		MessageExchangeVO exchangeVO = new MessageExchangeVO();
		exchangeVO.setExchangeName(me.getExchangeName());
		exchangeVO.setCreateTempChildQueue(me.isCreateTempChildQueue());
		exchangeVO.setMirror(me.isMirror());
		exchangeVO.setMirrorNodes(me.getMirrorNodes());
		exchangeVO.setMirrorNumber(me.getMirrorNumber());
		messageExchangeVOMap.put(me.getExchangeName(), exchangeVO);
	}

    public MessageConsumerSourceVO getConsumerSource(String consumerSourceType) {
        return ExchangeQueueMappingManager.messageConsumerSourceVOMap
                .get(consumerSourceType);
    }

    public MessageExchangeVO getExchangeByName(String exchangeName) {
        return ExchangeQueueMappingManager.messageExchangeVOMap
                .get(exchangeName);
    }

    public MessageQueueVO getQueueByName(String queueName) {
        return ExchangeQueueMappingManager.messageQueueVOMap.get(queueName);
    }

    public MessageVO getMessageByBusinessType(String businessType) {
        return ExchangeQueueMappingManager.messageVOMap.get(businessType);
    }

    public MessageConsumerVO getConsumer(String consumerSource,
                                         String consumerID) {
        return null;
    }

    public List<String> getAllExchanges() {
        return new ArrayList<String>(
                ExchangeQueueMappingManager.messageExchangeVOMap.keySet());
    }


    public static ExchangeQueueMappingManager getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		getInstance();
		System.out.println(messageQueueVOMap);
	}
}
