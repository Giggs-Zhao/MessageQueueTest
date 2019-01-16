package com.zhaolearn.rabbitmq3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 这个类时用于测试MQ4的延时接收的
 * @author: HeHaoZhao
 * @date: 2019/1/16 11:00
 */
@Component
@RabbitListener(queues = "message.center.create")
public class TestTTL4 {

    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(TestTTL4.class);

    @RabbitHandler
    public void handler(String content) {
        logger.info("消费内容：{}", content);
    }
}

