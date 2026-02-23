package com.ecommerce.notificacao_service.model;

import com.ecommerce.notificacao_service.mensageria.payload.PagamentoConfirmacaoPayload;
import com.ecommerce.notificacao_service.mensageria.payload.PedidoConfirmacaoPayload;
import com.ecommerce.notificacao_service.model.enums.NotificacaoTipo;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Notificacao {

    @Id
    private String id;
    private NotificacaoTipo notificacaoTipo;
    private LocalDateTime notificacaoDataCriacao;
    private PedidoConfirmacaoPayload pedidoConfirmacaoPayload;
    private PagamentoConfirmacaoPayload pagamentoConfirmacaoPayload;
}
