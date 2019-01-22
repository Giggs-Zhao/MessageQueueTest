package com.zhaolearn.activemqtesttest;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer1 {
    @JmsListener(destination = "testactive")
    public void receiveQueue(String text) {
        System.out.println("Consumer1接收到："+text);
    }
}