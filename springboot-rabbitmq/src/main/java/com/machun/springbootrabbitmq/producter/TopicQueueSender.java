package com.machun.springbootrabbitmq.producter;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 21:06
 * @UpdateDate: 2020/4/4 21:06
 * @menu
 */

@Component
public class TopicQueueSender {


    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void topicMessageSend(String message) {
        String context = message +" : "+ new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("myExchange","topic.message",context);

    }

    public void topicMessagesSend(String message) {
        String context = message +" : "+ new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("myExchange","topic.messages",context);

    }
}
