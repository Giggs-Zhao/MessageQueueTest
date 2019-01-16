package com.zhaolearn.rabbitmq5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Sender {
    private final static Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Object messageContent, String exchange, String routerKey, final int delayTimes) {
        if (!StringUtils.isEmpty(exchange)) {
            LOGGER.info("-----------------这里是send:延迟：{}毫秒写入消息队列：{}，消息内容：{}", delayTimes, routerKey, messageContent);
            // 执行发送消息到指定队列
            rabbitTemplate.convertAndSend(exchange, routerKey, messageContent, message -> {
                // 设置延迟毫秒值
                message.getMessageProperties().setDelay(delayTimes);
                LOGGER.info("------------这里是send确认：{}",delayTimes);
                return message;
            });
        } else {
            LOGGER.error("未找到队列消息：{}，所属的交换机", exchange);
        }
    }
}
