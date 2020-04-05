package com.machun.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 22:12
 * @UpdateDate: 2020/4/4 22:12
 * @menu
 */

@Configuration
public class FanoutRabbitConfig {



    /**
     * 定义队列
     * @return
     */
    @Bean
    public Queue messageA() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue messageB() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue messageC() {
        return new Queue("fanout.C");
    }


    /**
     * 定义交换机
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }


    /**
     * 分部进行绑定
     * @param messageA
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeA(Queue messageA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue messageB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageB).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue messageC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageC).to(fanoutExchange);
    }
}


