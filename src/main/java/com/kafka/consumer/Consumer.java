package com.kafka.consumer;

import com.kafka.config.Configuration;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Consumer implements Runnable {

    @Override
    public void run() {

        Properties consumerConfig = getConsumerConfig();

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerConfig)) {
            consumer.subscribe(Collections.singletonList(Configuration.TOPIC_NAME.getConfigValue()));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }
        }
    }

    private static Properties getConsumerConfig() {

        Properties consumerConfig = new Properties();
        consumerConfig.put(Configuration.BOOTSTRAP_SERVERS.getConfigKey(), Configuration.BOOTSTRAP_SERVERS.getConfigValue());
        consumerConfig.put(Configuration.CONSUMER_GROUP_ID.getConfigKey(), Configuration.CONSUMER_GROUP_ID.getConfigValue());
        consumerConfig.put(Configuration.kEY_DESERIALIZER.getConfigKey(), Configuration.kEY_DESERIALIZER.getConfigValue());
        consumerConfig.put(Configuration.VALUE_DESERIALIZER.getConfigKey(), Configuration.VALUE_DESERIALIZER.getConfigValue());

        return consumerConfig;
    }

}