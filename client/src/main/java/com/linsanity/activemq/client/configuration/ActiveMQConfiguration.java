package com.linsanity.activemq.client.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@Configuration
@EnableJms
public class ActiveMQConfiguration {

    @Bean("userPushListenerMQ")
    public Queue userQueue(){
        return new ActiveMQQueue("userPushListenerMQ");
    }

}
