package com.example.kafka;

import com.example.kafka.service.PublisherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(KafkaApplication.class, args);
        final PublisherService publisherService = applicationContext.getBean(PublisherService.class);
        publisherService.sendMessage("Hi! How are you doing?");
    }

}
