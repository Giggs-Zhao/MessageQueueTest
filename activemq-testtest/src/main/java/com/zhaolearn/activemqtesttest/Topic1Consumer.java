package com.zhaolearn.activemqtesttest;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Topic1Consumer {
    @JmsListener(destination = "topic.name")
    public void receiveQueue(String text) {
        System.out.println("Topic2Consumer"+text);
    }
}