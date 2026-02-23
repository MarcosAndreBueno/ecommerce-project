package com.ecommerce.pedido_service.mensageria;

import com.ecommerce.pedido_service.mensageria.payload.PedidoConfirmacaoPayload;
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
public class PedidoProducer {

    private final KafkaTemplate<String, PedidoConfirmacaoPayload> kafkaTemplate;

    public void enviarNotificacaoConfimacaoPedido(PedidoConfirmacaoPayload pedidoConfirmacaoPayload) {
        log.info("Enviando confirmação de pedido");
        Message<PedidoConfirmacaoPayload> mensagem = MessageBuilder
                .withPayload(pedidoConfirmacaoPayload)
                .setHeader(TOPIC, "pedido-topic")
                .build();

        kafkaTemplate.send(mensagem);
    }
}
