package com.abot.pulsargo.service;

import org.apache.pulsar.client.api.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * @author weibao
 */
@Component
public class SimpleConsumer {
    @Resource
    private PulsarClient client;

    public void consumeMsg() throws PulsarClientException {
        // MessageListener避免线程阻塞，符合solid原则
        /*MessageListener myMessageListener = (consumer, msg) -> {
            try {
                System.out.println("Message received: " + new String(msg.getData()));
                consumer.acknowledge(msg);
            } catch (Exception e) {
                consumer.negativeAcknowledge(msg);
            }
        };*/

        //======================================================
        // 使用客户端创建消费者
        Consumer consumer = client.newConsumer()
                .topic("my-topic")
                .subscriptionName("my-subscription")
                .subscriptionType(SubscriptionType.Key_Shared)
//                .readCompacted(true)  // 读取压缩主题 注意：Read compacted can only be used with exclusive or failover persistent subscriptions
                .subscribe();
        while (true) {
            // Wait for a message
            Message msg = consumer.receive();
            CompletableFuture asyncMessage = consumer.receiveAsync();
            try {
                asyncMessage.get();
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(3000);
                // Do something with the message
                System.out.println("Message received: " + new String(msg.getData()));

                // Acknowledge the message
                consumer.acknowledge(msg);
            } catch (Exception e) {
                // Message failed to process, redeliver later
                consumer.negativeAcknowledge(msg);
            }
        }

    }
}


