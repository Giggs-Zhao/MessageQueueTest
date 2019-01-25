package com.zhaolearn.activemq1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Activemq1ApplicationTests {

    @Autowired
    private Sender sender;
    @Autowired
    private TopicSender topicSender;


    @Test
    public void tesQueue() {
        for (int i = 0; i < 10; i++) {
            sender.send("testactive", "发送Queue消息啦啦啦啦啦啦");
        }
    }

    @Test
    public void testQueueDelay() {
        for (int i = 0; i < 10; i++) {
            sender.delaySend("testactive", "延时发送Queue消息啦啦啦啦啦啦",300000L);
        }
    }

    @Test
    public void testTopic() {
        topicSender.send("topic.name", "发送Topic消息啦啦啦啦啦啦");
    }

    @Test
    public void testTopicDelay(){
        topicSender.delaySend("topic.name", "发送Topic消息啦啦啦啦啦啦",3000L);
    }

}

