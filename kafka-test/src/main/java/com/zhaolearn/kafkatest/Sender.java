package com.zhaolearn.kafkatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private final static Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String name,String key, String message) {
        LOGGER.info("kafka的消息={}", message);
        kafkaTemplate.send(name,message);
    }


}