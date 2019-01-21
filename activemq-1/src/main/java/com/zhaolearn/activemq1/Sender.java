package com.zhaolearn.activemq1;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.jms.Destination;

@Component
public class Sender {
    private final static Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    public void send(String destName, Object message){
        JmsTemplate jmsTemplate = jmsMessagingTemplate.getJmsTemplate();
        //开启订阅模式
        jmsTemplate.setPubSubDomain(true);
        Destination destination = new ActiveMQTopic(destName);
        System.out.println("发布消息：" + message);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
