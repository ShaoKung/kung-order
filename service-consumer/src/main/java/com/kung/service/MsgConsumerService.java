package com.kung.service;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;

@Service
@RocketMQMessageListener(
        topic = "TopicTest",
        consumerGroup = "test-group",
        selectorExpression = "*",
        consumeMode = ConsumeMode.CONCURRENTLY
)
public class MsgConsumerService implements RocketMQListener<String> {
    public static final Logger log = LoggerFactory.getLogger(MsgConsumerService.class);
    @Override
    public void onMessage(String s) {
        log.info("com.kung.service.MsgConsumerService.onMessage receive info :"+ s);
    }
}
