package com.machun.springbootrabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 21:13
 * @UpdateDate: 2020/4/4 21:13
 * @menu
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicMessagesQueueReceiver {

    @RabbitHandler
    public  void process(String message)
    {

        System.out.println("TopicMessagesQueueReceiver: "+message);
    }
}
