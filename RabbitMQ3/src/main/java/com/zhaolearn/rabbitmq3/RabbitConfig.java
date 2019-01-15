package com.zhaolearn.rabbitmq3;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {



    /**
     * 定义firsttDirect队列
     *
     * @return
     */
    @Bean
    public Queue firsttDirectQueue() {
        return new Queue(QueueType.FIRSTDIRECT);
    }
    /**
     * 定义个DirectExchange交换器
     * @return
     */
    @Bean
    DirectExchange firstDirectExchange() {
        return new DirectExchange(QueueType.FIRSTDIRECT);
    }

    @Bean
    public Binding fanoutExchangeFirstDirectBind() {
        return BindingBuilder.bind(firsttDirectQueue()).to(firstDirectExchange()).with(QueueType.FIRSTDIRECTKEY);
    }
}