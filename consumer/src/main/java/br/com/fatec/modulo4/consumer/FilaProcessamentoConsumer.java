package br.com.fatec.modulo4.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import br.com.fatec.modulo4.dto.FilaProcessamento;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FilaProcessamentoConsumer {

    @RetryableTopic(
            autoCreateTopics = "false",
            backoff = @Backoff(
                    delay = 15000,
                    multiplier = 2.0,
                    maxDelay = 54000),
            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE
    )
    @KafkaListener(
            topics = "${spring.kafka.topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerFactory"
    )
    public void listener(ConsumerRecord<String, FilaProcessamento> consumerRecord) {
        try {
            log.info(
                    "Mensagem recebida | topic={} | key={} | value={} | partition={} | offset={}",
                    consumerRecord.topic(),
                    consumerRecord.key(),
                    consumerRecord.value(),
                    consumerRecord.partition(),
                    consumerRecord.offset()
            );

        } catch (Exception e) {
            log.error("Erro ao processar mensagem | key={} | value={}", consumerRecord.key(), consumerRecord.value(), e);
            throw e;
        }
    }
}
