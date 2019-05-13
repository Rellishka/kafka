package com.example.kafka.service;

import com.example.kafka.config.KafkaTopicConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    private KafkaTopicConfig kafkaTopicConfig;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public PublisherServiceImpl(KafkaTopicConfig kafkaTopicConfig, KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTopicConfig = kafkaTopicConfig;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String topic, String message) {
        final ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                LOGGER.info("Sent message=[{}] with offset=[{}]",
                        message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable throwable) {
                LOGGER.error("Unable to send message=[{}] due to : {}", message, throwable.getMessage());
            }

        });
    }

    @Override
    public void sendMessageToPartition(String topic, String msg, int partition) {
        kafkaTemplate.send(topic, partition, null, msg);
    }
}
