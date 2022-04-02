package com.amdocs.engagewebgrabber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EngageWebGrabberApplicationTests {

    @Test
    public void contextLoads() {
        /*GetAndPostToMQ mq = new GetAndPostToMQ();
        mq.postMsg("stam");*/
    }

}
