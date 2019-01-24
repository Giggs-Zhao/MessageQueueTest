package com.zhaolearn.activemqtesttest;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class Consumer1 {
    @JmsListener(destination = "testactive", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue(String text) {
        System.out.println("Consumer1接收到："+text);
    }
}