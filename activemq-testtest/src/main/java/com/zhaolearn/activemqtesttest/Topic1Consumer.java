package com.zhaolearn.activemqtesttest;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;


@Component
public class Topic1Consumer {
    @JmsListener(destination = "topic.name", containerFactory = "jmsListenerContainerTopic")
    public void subscriber(Object obj) {
        System.out.println("收到订阅消息：" + obj);
        try {
            //接受对象消息
            if (obj instanceof ActiveMQObjectMessage) {
                Object sourObj = ((ActiveMQObjectMessage) obj).getObject();
                System.out.println("收到订阅消息：" + sourObj);
            }else if(obj instanceof ActiveMQTextMessage){
                String sourObj = ((ActiveMQTextMessage) obj).getText();
                System.out.println("收到订阅消息：" + sourObj);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}