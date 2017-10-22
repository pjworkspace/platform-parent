package com.framework.rabbitmq.event;

import java.util.Date;

/**
 * @author wangjie
 * @version 1.0.0
 * @Created with IntelliJ IDEA.
 * @Date: 2015/11/14 17:00
 */
public interface IEvent {

    /**
     * 消息子类型
     *
     * @return
     */
    EventTypeEnum getType();

    /**
     * 得到消息流水号
     *
     * @return
     */
    String getSerialNum();

    /**
     * 得到消息创建时间
     *
     * @return
     */
    Date getTime();

    String toString();
}
