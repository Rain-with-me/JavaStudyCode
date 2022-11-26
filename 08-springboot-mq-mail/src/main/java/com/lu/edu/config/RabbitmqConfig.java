package com.lu.edu.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Value("${mq.queue}")
    private String MAIL_REGISTER_QUEUE;
    @Value("${mq.exchange}")
    private String MAIL_REGISTER_EXCHANGE;
    @Value("${mq.router-key}")
    private String MAIL_REGISTER_ROUTING_KEY;

    /** 邮件 **/
    @Bean
    public Queue mailQueue() {
        return new Queue(MAIL_REGISTER_QUEUE, true, false, false, null);
    }

    @Bean
    public Exchange mailExchange() {
        return new TopicExchange(MAIL_REGISTER_EXCHANGE, true, false, null);
    }

    @Bean
    public Binding orderBinding() {
        return new Binding(MAIL_REGISTER_QUEUE, Binding.DestinationType.QUEUE, MAIL_REGISTER_EXCHANGE,
            MAIL_REGISTER_ROUTING_KEY, null);
    }

    /** json输出   消息转换器 **/
//    ，一方面它能够把我们的非标准化Message对象转换成我们的目标Message对象，这主要是用在发送消息的时候；
//    还有一方面它又能够把我们的Message对象转换成相应的目标对象，这主要是用在接收消息的时候
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}