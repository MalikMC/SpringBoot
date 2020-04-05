package com.machun.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 20:49
 * @UpdateDate: 2020/4/4 20:49
 * @menu
 */
@Configuration
public class TopicRabbitConfig {

//    RabbitMQ提供了四种Exchange：fanout,direct,topic,header
//    header模式在实际使用中较少
//    性能排序：fanout > direct >> topic。比例大约为11：10：6
//Topic 是 RabbitMQ 中最灵活的一种方式，可以根据 routing_key 自由的绑定不同的队列
    //queueMessages 同时匹配两个队列，queueMessage 只匹配“topic.message”队列

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    /**
     * 定义队列 message
     * @return
     */
    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }

    /**
     * 定义队列 messages
     * @return
     */
    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }


    /**
     * 定义交换机
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("myExchange");
    }

    /**
     * 将队列和交换机绑定
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    /**
     * 将队列和交换机绑定
     * @param queueMessages
     * @param exchange
     * @return
     */

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
