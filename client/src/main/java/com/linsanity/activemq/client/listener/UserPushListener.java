package com.linsanity.activemq.client.listener;

import com.alibaba.fastjson.JSON;
import com.linsanity.activemq.client.controller.websocket.WebsocketController;
import com.linsanity.activemq.client.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component("userPushListener")
public class UserPushListener implements MessageListener {

    protected static final Logger log = LoggerFactory.getLogger(UserPushListener.class);

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try{
            //获取数据
            String jsonStr = textMessage.getText();
            log.info("[UserPushListener.onMessage]:receive message is,"+ jsonStr);
            if (jsonStr != null) {
                User info = JSON.parseObject(jsonStr, User.class);
                System.out.println("==============================接受到的用户信息 开始====================================");
                System.out.println(info.toString());
                System.out.println("==============================接受到的用户信息 结束====================================");
                WebsocketController.broadcast("user", jsonStr);
            }
        }catch (JMSException e){
            log.error("[UserPushListener.onMessage]:receive message occured an exception",e);
        }
        log.info("[UserPushListener.onMessage]:end onMessage.");
    }
}
