package com.example.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "${message.topic.name}")
    public void handleMessage(String message, Message<String> stringMessage) {
        MessageHeaders messageHeaders = stringMessage.getHeaders();
        LOGGER.info("received message: {} from partitionId {}",
                message,
                messageHeaders.get(KafkaHeaders.RECEIVED_PARTITION_ID));
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "${partitioned.topic.name}", partitions = {"0", "3"}))
    public void handleMessagePartitioned(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        LOGGER.info("received message: {} from partitionId {}",
                message,
                partition);
    }

}
