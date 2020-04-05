package com.machun.springbootrabbitmq.producter;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 22:14
 * @UpdateDate: 2020/4/4 22:14
 * @menu
 */
@Component
public class FanoutQueueSender {
    @Autowired
    RabbitTemplate rabbitTemplate;
   public  void Send(){
       String context = "hi, fanout msg ";
       System.out.println("Sender : " + context);
       this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
   }

}
