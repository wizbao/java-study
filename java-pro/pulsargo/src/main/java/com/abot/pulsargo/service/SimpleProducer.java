package com.abot.pulsargo.service;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * @author weibao
 */
@Component
public class SimpleProducer {
    @Resource
    private PulsarClient client;

    public void sendMsg() throws PulsarClientException {
        // 使用客户端创建生产者
        Producer<String> producer = client.newProducer(Schema.STRING)
                .producerName("")
                .sendTimeout(0,TimeUnit.SECONDS)
                .topic("my-topic")
                .create();
        producer.newMessage()
                .key("my-key")  // key和value是消息密钥，用于主题压缩
                .value("helloworld")
                .deliverAfter(60, TimeUnit.SECONDS)  // 延迟发送 仅共享和密钥共享订阅支持延迟消息传递。在其他订阅中，延迟的消息会立即发送。默认的订阅类型是独占
                .send();
    }
}
