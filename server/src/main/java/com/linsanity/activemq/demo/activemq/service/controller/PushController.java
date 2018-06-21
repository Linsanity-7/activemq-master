package com.linsanity.activemq.demo.activemq.service.controller;

import com.linsanity.activemq.demo.activemq.domain.User;
import com.linsanity.activemq.demo.activemq.service.result.ResultResponse;
import com.linsanity.activemq.demo.activemq.service.service.PushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/push")
public class PushController {

    private static final Logger log = LoggerFactory.getLogger(PushController.class);

    @Resource(name="userPushService")
    private PushService userPushService;

    @RequestMapping(value="/user",method= RequestMethod.POST)
    @ResponseBody
    public ResultResponse userPush(User info){
        log.info("=========进入userPush()方法========");
        ResultResponse respone = new ResultResponse();
        try {
            userPushService.push(info);
            respone.setData(info);
        } catch (Exception e) {
            log.error("发送消息时出现异常",e);
            respone = new ResultResponse(0, e.getMessage());
        }
        return respone;
    }
}
