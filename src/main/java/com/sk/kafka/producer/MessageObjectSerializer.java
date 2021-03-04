package com.sk.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MessageObjectSerializer implements Serializer<MessageObject> {
    private final static Logger LOG = LoggerFactory.getLogger(MessageObjectSerializer.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, MessageObject data) {
        byte[] returnValue = null;
        try {
            returnValue = objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception e) {
            LOG.error("Error in serializing " + data, e);
        }
        return returnValue;
    }

    @Override
    public void close() {

    }

}