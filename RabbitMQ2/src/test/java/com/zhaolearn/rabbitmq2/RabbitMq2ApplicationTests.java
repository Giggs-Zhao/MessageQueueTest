package com.zhaolearn.rabbitmq2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMq2ApplicationTests {
    @Autowired
    private Sender sender;
    @Test
    public void testStringSend() {
        sender.topicTopic1Send();
        sender.topicTopic2Send();
        sender.topicTopic3Send();
    }

}

