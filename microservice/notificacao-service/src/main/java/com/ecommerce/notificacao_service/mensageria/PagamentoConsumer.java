package com.ecommerce.notificacao_service.mensageria;

import com.ecommerce.notificacao_service.mensageria.payload.PagamentoConfirmacaoPayload;
import com.ecommerce.notificacao_service.model.Notificacao;
import com.ecommerce.notificacao_service.repository.NotificacaoRepository;
import com.ecommerce.notificacao_service.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.ecommerce.notificacao_service.model.enums.NotificacaoTipo.PAGAMENTO_CONFIRMACAO;
import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class PagamentoConsumer {

    private final NotificacaoRepository notificacaoRepository;
    private final EmailService emailService;

    @KafkaListener(topics = "pagamento-confirmado-topic")
    public void consumirPagamentoConfirmado(PagamentoConfirmacaoPayload pagamentoConfirmacaoPayload) throws MessagingException {
        log.info(format("Consumindo mensagem do Tópico pagamento-confirmado-topic: %s", pagamentoConfirmacaoPayload));
        notificacaoRepository.save(
                Notificacao.builder()
                        .notificacaoTipo(PAGAMENTO_CONFIRMACAO)
                        .notificacaoDataCriacao(LocalDateTime.now())
                        .pagamentoConfirmacaoPayload(pagamentoConfirmacaoPayload)
                        .build()
        );
        var clienteNomeCompleto = pagamentoConfirmacaoPayload.clienteNome() + " " + pagamentoConfirmacaoPayload.clienteSobrenome();
        emailService.enviarEmailConfirmacaoPagamento(
                pagamentoConfirmacaoPayload.clienteEmail(),
                clienteNomeCompleto,
                pagamentoConfirmacaoPayload.valorTotal(),
                pagamentoConfirmacaoPayload.pedidoReferencias()
        );
    }
}
