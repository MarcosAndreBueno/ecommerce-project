package com.ecommerce.pagamento_service.mensageria;

import com.ecommerce.pagamento_service.mensageria.payload.PagamentoNotificacaoPayload;
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
public class PagamentoProducer {

  private final KafkaTemplate<String, PagamentoNotificacaoPayload> kafkaTemplate;

  public void enviarNotificacaoPagamentoConfirmado(PagamentoNotificacaoPayload request) {
    log.info("Enviando notificação com body = < {} >", request);
    Message<PagamentoNotificacaoPayload> message = MessageBuilder
            .withPayload(request)
            .setHeader(TOPIC, "pagamento-topic")
            .build();

    kafkaTemplate.send(message);
  }
}
