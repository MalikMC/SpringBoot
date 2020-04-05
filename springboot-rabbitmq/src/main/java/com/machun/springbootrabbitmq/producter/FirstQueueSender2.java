package com.machun.springbootrabbitmq.producter;

import com.machun.springbootrabbitmq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 14:57
 * @UpdateDate: 2020/4/4 14:57
 * @menu
 */
@Component
public class FirstQueueSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        String context = message +" : "+ new Date();
        System.out.println("Sender 2 : " + context);
        this.rabbitTemplate.convertAndSend("firstQueue", context);

    }

    public void send(User user) {

        System.out.println("Sender 2 : " + user.toString());
        this.rabbitTemplate.convertAndSend("firstQueue", user);

    }
}
