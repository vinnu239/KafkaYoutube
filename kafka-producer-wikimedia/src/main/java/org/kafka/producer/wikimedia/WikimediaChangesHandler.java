package org.kafka.producer.wikimedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaChangesHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {
        // Initialization code
    }

    @Override
    public void onClosed() throws Exception {
        // Cleanup code
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info("onMessage called with data: " + messageEvent.getData());
        kafkaTemplate.send(topic, messageEvent.getData());
        LOGGER.info("Message sent to Kafka topic: " + topic);
    }

    @Override
    public void onComment(String comment) throws Exception {
        // Handle comments
    }

    @Override
    public void onError(Throwable t) {
        LOGGER.error("Error occurred: ", t);
    }
}