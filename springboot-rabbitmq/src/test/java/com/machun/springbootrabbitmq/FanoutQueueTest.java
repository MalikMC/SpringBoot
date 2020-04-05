package com.machun.springbootrabbitmq;

import com.machun.springbootrabbitmq.producter.FanoutQueueSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 23:29
 * @UpdateDate: 2020/4/4 23:29
 * @menu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutQueueTest {
    @Autowired
  private   FanoutQueueSender fanoutQueueSender;

    @Test
    public void testFanoutQueue() throws InterruptedException {

        fanoutQueueSender.Send();
        Thread.sleep(1000l);
    }

}
