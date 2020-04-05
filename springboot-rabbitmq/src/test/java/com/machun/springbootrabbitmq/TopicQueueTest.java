package com.machun.springbootrabbitmq;

import com.machun.springbootrabbitmq.consumer.TopicMessageQueueReceiver;
import com.machun.springbootrabbitmq.consumer.TopicMessagesQueueReceiver;
import com.machun.springbootrabbitmq.producter.TopicQueueSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 21:19
 * @UpdateDate: 2020/4/4 21:19
 * @menu
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicQueueTest {

    @Autowired
    TopicQueueSender topicQueueSender;
    @Test
    public void  topicMessageSend() throws Exception{
        topicQueueSender.topicMessageSend("I am a message from one");
        Thread.sleep(1000l);
    }


    @Test
    public void  topicMessagesSend() throws Exception{
        topicQueueSender.topicMessagesSend("I am a message from Two");
        Thread.sleep(1000l);
    }
}
