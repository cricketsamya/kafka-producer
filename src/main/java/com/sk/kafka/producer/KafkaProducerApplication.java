package com.sk.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication {
    private final static Logger LOG = LoggerFactory.getLogger(KafkaProducerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
        LOG.info("Server Started");

        final SampleMessageProducer sampleMessageProducer = new SampleMessageProducer();
        sampleMessageProducer.produce();
        LOG.info("Sample messages sent!");
    }
}
