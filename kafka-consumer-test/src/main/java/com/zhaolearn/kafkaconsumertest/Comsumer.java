package com.zhaolearn.kafkaconsumertest;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class Comsumer {
    private final static Logger LOGGER = LoggerFactory.getLogger(Comsumer.class);
//    @KafkaListener(topicPartitions = { @TopicPartition(topic = "test_topic", partitions = { "0"}) },groupId = "test")
@KafkaListener(topics = {"test_topic1"},groupId = "test")
    public void listen (ConsumerRecord<?, ?> record){
        LOGGER.info(record.toString());
        LOGGER.info("【消费{}主题, 第{}分区, 数据:{}, 偏移量:{}】", record.topic(), record.partition(), record.value(), record.offset());
    }
}
