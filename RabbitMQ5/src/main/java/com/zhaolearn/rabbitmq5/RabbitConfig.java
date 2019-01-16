package com.zhaolearn.rabbitmq5;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue messageQueue() {
        return new Queue(QueueEnum.MESSAGE_QUEUE.getQueueName(),true);
    }

    @Bean
    public CustomExchange messageDirect() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(QueueEnum.MESSAGE_QUEUE.getExchange(), "x-delayed-message", true, false, args);
    }



    @Bean
    public Binding messageBinding() {
        return BindingBuilder
                .bind(messageQueue())
                .to(messageDirect())
                .with(QueueEnum.MESSAGE_QUEUE.getRouteKey()).noargs();
    }

}