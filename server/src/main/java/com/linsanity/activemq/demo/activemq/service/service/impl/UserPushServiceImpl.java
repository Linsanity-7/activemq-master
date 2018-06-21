package com.linsanity.activemq.demo.activemq.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.linsanity.activemq.demo.activemq.domain.User;
import com.linsanity.activemq.demo.activemq.service.service.PushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service("userPushService")
public class UserPushServiceImpl implements PushService {

    private static final Logger log = LoggerFactory.getLogger(UserPushServiceImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("userServiceQueue")
    private Destination destination;

    @Override
    public void push(final Object info) {
        pushExecutor.execute(new Runnable() {
            @Override
            public void run() {
                log.info("=======进入消息发送线程=======");
                jmsTemplate.send(destination, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        log.info("=====执行发送消息到activeMQ消息队列中=====");
                        User p = (User) info;
                        return session.createTextMessage(JSON.toJSONString(p));
                    }
                });
            }
        });
    }
}
