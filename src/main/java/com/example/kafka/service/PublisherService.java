package com.example.kafka.service;

public interface PublisherService {
    void sendMessage(String topic, String msg);

    void sendMessageToPartition(String topic, String msg, int partition);
}
