package com.example.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value(value = "${message.topic.name}")
    private String messageTopicName;

    @Value(value = "${partitioned.topic.name}")
    private String partionedTopicName;

    @Value(value = "${message.groupId}")
    private String messageGroupId;

    @Value(value = "${partitioned.groupId}")
    private String partitionGroupId;

    public String getBootstrapAddress() {
        return bootstrapAddress;
    }

    public String getMessageTopicName() {
        return messageTopicName;
    }

    public String getPartionedTopicName() {
        return partionedTopicName;
    }

    public String getMessageGroupId() {
        return messageGroupId;
    }

    public String getPartitionGroupId() {
        return partitionGroupId;
    }
}

