package com.aia.kafka.message.listener;

import com.aia.kafka.message.support.MessageInput;
import com.aia.kafka.message.support.TopicSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.BinderFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

/**
 * @author FM
 * @Description
 * @create 2021-02-01 22:55
 */
@EnableBinding(MessageInput.class)
public class KafkaListener implements ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;

    @StreamListener(value= TopicSupport.INPUT_TOPIC_1)
    public void inputTopic1(Message message){
        System.out.println(message.getPayload());
        System.out.println(message.getHeaders());
        int i=1/0;
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        // if (acknowledgment != null) {
        //     System.out.println("Acknowledgment provided");
        //     acknowledgment.acknowledge();
        // }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // BinderFactory bean = applicationContext.getBean(BinderFactory.class);
        // bean.getBinder()
    }
}
