package com.zhaolearn.activemqtesttest;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;


@Component
public class TopicConsumer {
    @JmsListener(destination = "topic.name1", containerFactory = "jmsListenerContainerTopic")
    public void subscriber(Object obj) {
        try {
            //接受对象消息
            if (obj instanceof ActiveMQObjectMessage) {
                Object sourObj = ((ActiveMQObjectMessage) obj).getObject();
                System.out.println("收到订阅消息：" + sourObj);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}