package com.ecommerce.pagamento_service.mensageria;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificacaoProducer {

  private final KafkaTemplate<String, PagamentoNotificacaoRequest> kafkaTemplate;

  public void enviarNotificacao(PagamentoNotificacaoRequest request) {
    log.info("Enviando notificação com body = < {} >", request);
    Message<PagamentoNotificacaoRequest> message = MessageBuilder
            .withPayload(request)
            .setHeader(TOPIC, "pagamento-topic")
            .build();

    kafkaTemplate.send(message);
  }
}
