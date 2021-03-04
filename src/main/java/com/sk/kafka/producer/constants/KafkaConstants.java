package com.sk.kafka.producer.constants;

public interface KafkaConstants {
    //Multiple Brokers can be used comma separated
    String BROKERS = "localhost:9092";
    Integer MESSAGE_COUNT = 1000;
    //Id of the producer to determine source of the request by the broker
    String CLIENT_ID = "cricketsamya";
    String TOPIC_NAME = "chat";
}
