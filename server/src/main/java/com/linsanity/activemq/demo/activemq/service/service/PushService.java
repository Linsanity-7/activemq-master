package com.linsanity.activemq.demo.activemq.service.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 推送接口
 * @author lin
 * @version 1.0
 */
public interface PushService {

    public final ExecutorService pushExecutor = Executors.newFixedThreadPool(10);

    public void push(Object info);

}
