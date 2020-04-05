package com.machun.springbootrabbitmq;

import com.machun.springbootrabbitmq.consumer.FirstQueueReceiver1;
import com.machun.springbootrabbitmq.entity.User;
import com.machun.springbootrabbitmq.producter.FirstQueueSender1;
import com.machun.springbootrabbitmq.producter.FirstQueueSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 15:10
 * @UpdateDate: 2020/4/4 15:10
 * @menu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstQueueTest {

    @Autowired
    private FirstQueueSender1 firstQueueSender1;
    @Autowired
    private FirstQueueSender2 firstQueueSender2;
    @Autowired
    private FirstQueueReceiver1 firstQueueReceiver1;


    @Test
    public void sendString() throws Exception {

        new Thread(() -> {
            for(int i=0;i<10;i++){
                firstQueueSender1.send("Hi,I am a message create by firstThread "+i);}
        } ,"firstThread").start();

        new Thread(() -> {
            for(int i=0;i<10;i++){
                firstQueueSender2.send("Hi,I am a message create by scendThread "+i);}
        } ,"scendThread").start();

        Thread.sleep(1000l);
        firstQueueReceiver1.process();
    }

    @Test
    public void sendObject() throws Exception {

        new Thread(() -> {
            for(int i=0;i<10;i++){
                User user=new User("Ma Chun","男",i);
                firstQueueSender1.send(user);}
        } ,"SendUserThread").start();

        Thread.sleep(1000l);

    }



}
