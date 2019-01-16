package com.zhaolearn.rabbitmq5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMq5ApplicationTests {
    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() {
        // 测试延迟10秒
        sender.send("测试延迟消费,写入时间：" + new Date(),
                QueueEnum.MESSAGE_QUEUE.getExchange(),
                QueueEnum.MESSAGE_QUEUE.getRouteKey(),
                10000);
    }

}

