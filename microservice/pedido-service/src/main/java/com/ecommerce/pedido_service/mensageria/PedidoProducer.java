package com.ecommerce.pedido_service.mensageria;

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

    private final KafkaTemplate<String, PedidoConfirmacao> kafkaTemplate;

    public void enviarConfimacaoPedido(PedidoConfirmacao pedidoConfirmacao) {
        log.info("Enviando confirmação de pedido");
        Message<PedidoConfirmacao> mensagem = MessageBuilder
                .withPayload(pedidoConfirmacao)
                .setHeader(TOPIC, "pedido-topic")
                .build();

        kafkaTemplate.send(mensagem);
    }
}
