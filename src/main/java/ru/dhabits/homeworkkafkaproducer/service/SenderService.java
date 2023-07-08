package ru.dhabits.homeworkkafkaproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.dhabits.homeworkkafkaproducer.config.KafkaProducerConfig;

@Service
@RequiredArgsConstructor
@Slf4j
public class SenderService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        var parts = message.split(";");

        String key = null;
        String value = message;

        if (parts.length > 1) {
            key = parts[0];
            value = parts[1];
        }

        log.info("KEY from message: {}", key);
        kafkaTemplate.send(KafkaProducerConfig.TOPIC_NAME, key, value);
    }
}
