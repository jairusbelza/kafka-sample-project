package com.belza.sample.kafka.kafkasampleproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    @Override
    public void run(String... args) {
        for (int i = 0; i < 150; i++) {
            String key = Integer.toString(i);
            String value = String.format("MyMessage: %s", key);
            kafkaTemplate.send(topic, key, value);
        }
    }
}
