package com.linsanity.activemq.demo.activemq.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@Configuration
@EnableJms
public class ActiveMQConfiguration {

    @Bean("userServiceQueue")
    public Queue userQueue(){
        return new ActiveMQQueue("userServiceQueue");
    }

}
