package com.machun.springbootrabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 14:51
 * @UpdateDate: 2020/4/4 14:51
 * @menu
 */

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue Queue() {
        return new Queue("firstQueue");
    }
}
