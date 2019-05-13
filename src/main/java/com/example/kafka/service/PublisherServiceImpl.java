package com.example.kafka.service;

import com.example.kafka.config.KafkaTopicConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {
    private KafkaTopicConfig kafkaTopicConfig;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public PublisherServiceImpl(KafkaTopicConfig kafkaTopicConfig, KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTopicConfig = kafkaTopicConfig;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send(kafkaTopicConfig.getTopicName(), message);
    }
}
