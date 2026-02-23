package com.ecommerce.notificacao_service.mensageria;

import com.ecommerce.notificacao_service.mensageria.payload.PedidoConfirmacaoPayload;
import com.ecommerce.notificacao_service.model.Notificacao;
import com.ecommerce.notificacao_service.repository.NotificacaoRepository;
import com.ecommerce.notificacao_service.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.ecommerce.notificacao_service.model.enums.NotificacaoTipo.PEDIDO_CONFIRMACAO;
import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class PedidoConsumer {

    private final NotificacaoRepository notificacaoRepository;
    private final EmailService emailService;

    @KafkaListener(topics = "pedido-confirmado-topic")
    public void consumirPedidoConfirmado(PedidoConfirmacaoPayload pedidoConfirmacaoPayload) throws MessagingException {
        log.info(format("Consumindo mensagem do Tópico pedido-confirmado-topic: %s", pedidoConfirmacaoPayload));
        notificacaoRepository.save(
                Notificacao.builder()
                        .notificacaoTipo(PEDIDO_CONFIRMACAO)
                        .notificacaoDataCriacao(LocalDateTime.now())
                        .pedidoConfirmacaoPayload(pedidoConfirmacaoPayload)
                        .build()
        );
        var clienteNomeCompleto = pedidoConfirmacaoPayload.cliente().nome() + " " + pedidoConfirmacaoPayload.cliente().sobrenome();
        emailService.enviarEmailConfirmacaoPedido(
                pedidoConfirmacaoPayload.cliente().email(),
                clienteNomeCompleto,
                pedidoConfirmacaoPayload.valorTotal(),
                pedidoConfirmacaoPayload.pedidoReferencias(),
                pedidoConfirmacaoPayload.produtos()
        );
    }
}
