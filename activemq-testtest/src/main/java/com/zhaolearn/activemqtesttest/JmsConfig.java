package com.zhaolearn.activemqtesttest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

@Configuration
public class JmsConfig {
    @Bean
    JmsListenerContainerFactory<?> myJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory simpleJmsListenerContainerFactory = new SimpleJmsListenerContainerFactory();
        simpleJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        //开启订阅模式
        simpleJmsListenerContainerFactory.setPubSubDomain(true);
        //开启持久化订阅,订阅端不在线能保持未消费的消息
        simpleJmsListenerContainerFactory.setClientId("yuxi");
        simpleJmsListenerContainerFactory.setSubscriptionDurable(true);
        return simpleJmsListenerContainerFactory;
    }
}
