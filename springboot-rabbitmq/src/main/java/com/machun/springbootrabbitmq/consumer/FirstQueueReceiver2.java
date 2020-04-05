package com.machun.springbootrabbitmq.consumer;

import com.machun.springbootrabbitmq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 15:03
 * @UpdateDate: 2020/4/4 15:03
 * @menu
 */

@Component
@RabbitListener(queues = "firstQueue")
public class FirstQueueReceiver2 {



    public void process() {
        System.out.println("Receiver 2 Start");
    }

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver  2 : " + message);
    }

    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver  2 : " + user.toString());
    }


}
