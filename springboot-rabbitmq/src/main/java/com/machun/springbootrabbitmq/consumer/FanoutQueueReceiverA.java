package com.machun.springbootrabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 22:18
 * @UpdateDate: 2020/4/4 22:18
 * @menu
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutQueueReceiverA {
    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver A: " + message);
    }
}
