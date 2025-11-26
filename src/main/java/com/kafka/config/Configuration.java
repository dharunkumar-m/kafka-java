package com.kafka.config;

public enum Configuration {

    BOOTSTRAP_SERVERS("bootstrap.servers", "dharun-11772t:9092"),
    TOPIC_NAME(null, "Topic-A"),

    CONSUMER_GROUP_ID("group.id", "consumer-group-1"),

    kEY_SERIALIZER("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"),
    VALUE_SERIALIZER("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"),

    kEY_DESERIALIZER("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"),
    VALUE_DESERIALIZER("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    private final String key;
    private final String value;

    Configuration(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getConfigKey() {
        return key;
    }

    public String getConfigValue() {
        return value;
    }

}