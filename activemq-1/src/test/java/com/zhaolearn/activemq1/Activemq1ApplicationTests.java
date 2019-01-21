package com.zhaolearn.activemq1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Activemq1ApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void testLazy() {
        sender.send("testactive", "发送消息啦啦啦啦啦啦");
    }

}

