package com.sk.kafka.producer;

import com.sk.kafka.producer.constants.KafkaConstants;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SampleMessageProducer {

    private final static Logger LOG = LoggerFactory.getLogger(SampleMessageProducer.class);
    final List<String> commands = Arrays.asList("SEND PUSH", "SEND EMAIL", "DELETE LOG");
    final Random random = new Random();

    public void produce() {

        final Producer<String, MessageObject> producer = MessageProducer.create();
        for (int index = 0; index < KafkaConstants.MESSAGE_COUNT; index++) {
            final UUID uuid = UUID.randomUUID();
            final MessageObject messageObject = new MessageObject();
            messageObject.setIdentifier(uuid.toString());
            messageObject.setAction(commands.get(random.nextInt(commands.size())));
            final ProducerRecord<String, MessageObject> record = new ProducerRecord<>(KafkaConstants.TOPIC_NAME, uuid.toString(),
                    messageObject);
            try {
                final RecordMetadata sentMessageMetadata = producer.send(record).get();
                LOG.info("Message " + messageObject + " | Partition " + sentMessageMetadata.partition()
                        + " | Offset " + sentMessageMetadata.offset());
            } catch (Exception e) {
                LOG.error("Error in sending record", e);
            }
        }
    }
}
