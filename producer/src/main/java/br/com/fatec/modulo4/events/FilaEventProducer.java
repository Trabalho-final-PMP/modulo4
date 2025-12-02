package br.com.fatec.modulo4.events;

import br.com.fatec.modulo4.dto.FilaProcessamento;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FilaEventProducer {
    private final KafkaTemplate<String, FilaProcessamento> kafkaTemplate;
    private final String topicName;

    public FilaEventProducer(
            KafkaTemplate<String, FilaProcessamento> kafkaTemplate,
            @Value("${spring.kafka.topic}") String topicName
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void sendMessage(FilaProcessamento filaProcessamento) {
        kafkaTemplate.send(topicName, UUID.randomUUID().toString(), filaProcessamento);
    }
}
