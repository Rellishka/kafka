package com.example.kafka.controller;

import com.example.kafka.config.KafkaTopicConfig;
import com.example.kafka.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private PublisherService publisherService;
    private KafkaTopicConfig kafkaTopicConfig;

    @Autowired
    public MessageController(KafkaTopicConfig kafkaTopicConfig, PublisherService publisherService){
        this.kafkaTopicConfig = kafkaTopicConfig;
        this.publisherService = publisherService;
    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestParam String message){
        publisherService.sendMessage(kafkaTopicConfig.getMessageTopicName(), message);
    }


    @PostMapping("/sendMessage/partitioned")
    public void sendMessageToPartition(@RequestParam String message, @RequestParam int partition){
        publisherService.sendMessageToPartition(kafkaTopicConfig.getPartionedTopicName(), message, partition);
    }

}
