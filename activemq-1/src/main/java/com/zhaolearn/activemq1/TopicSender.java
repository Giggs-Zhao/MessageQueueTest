package com.zhaolearn.activemq1;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class TopicSender {
    private final static Logger LOGGER = LoggerFactory.getLogger(TopicSender.class);
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    public void send(String destName, Object message){
        System.out.println("发布消息：" + message);
        jmsMessagingTemplate.convertAndSend(destName, message);
    }
    public void delaySend(String destName, Object message, Long time){
        JmsTemplate jmsTemplate = jmsMessagingTemplate.getJmsTemplate();
        //开启订阅模式
        jmsTemplate.setPubSubDomain(true);
        Destination destination = new ActiveMQTopic(destName);
        jmsTemplate.convertAndSend(destination,message,new ScheduleMessagePostProcessor(time));
        LOGGER.info("发送"+message);
    }
}
