package com.aia.kafka.message.support;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author FM
 * @Description
 * @create 2021-02-01 22:57
 */
public interface MessageInput {

    @Input(TopicSupport.INPUT_TOPIC_1)
    SubscribableChannel receive();

}
