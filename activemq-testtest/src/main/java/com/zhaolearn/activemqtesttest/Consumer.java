package com.zhaolearn.activemqtesttest;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

@Service
public class Consumer {
    @JmsListener(destination = "testactive")
    public void receiveQueue(String text) {
        System.out.println(text);
    }
}