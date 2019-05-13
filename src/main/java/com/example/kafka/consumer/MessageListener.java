package com.example.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "${topic.name}", groupId = "${value.groupId}")
    public void handle(String message, Message<String> stringMessage) {
        MessageHeaders messageHeaders = stringMessage.getHeaders();
        System.out.println(String.format("received message: %s from partitionId %s",
                message,
                messageHeaders.get(KafkaHeaders.RECEIVED_PARTITION_ID)));
    }
}
