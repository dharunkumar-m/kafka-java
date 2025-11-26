package com.kafka.producer;

import com.kafka.config.Configuration;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer implements Runnable {

    @Override
    public void run() {
        Properties producerConfig = getProducerConfig();

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(producerConfig)) {
            while(true) {
                producer.send(new ProducerRecord<>(Configuration.TOPIC_NAME.getConfigValue(), "key", "hello consumer from producer "));
            }
        }

    }

    private static Properties getProducerConfig() {
        
        Properties producerConfig = new Properties();
        producerConfig.put(Configuration.BOOTSTRAP_SERVERS.getConfigKey(), Configuration.BOOTSTRAP_SERVERS.getConfigValue());
        producerConfig.put(Configuration.kEY_SERIALIZER.getConfigKey(), Configuration.kEY_SERIALIZER.getConfigValue());
        producerConfig.put(Configuration.VALUE_SERIALIZER.getConfigKey(), Configuration.VALUE_SERIALIZER.getConfigValue());

        return producerConfig;
    }
    
}