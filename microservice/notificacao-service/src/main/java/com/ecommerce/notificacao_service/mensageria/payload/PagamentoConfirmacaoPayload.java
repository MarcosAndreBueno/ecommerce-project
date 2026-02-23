package com.ecommerce.notificacao_service.mensageria.payload;

import com.ecommerce.notificacao_service.model.enums.MetodoPagamento;

import java.math.BigDecimal;

public record PagamentoConfirmacaoPayload(
        String pedidoReferencias,
        BigDecimal valorTotal,
        MetodoPagamento metodoPagamento,
        String clienteNome,
        String clienteSobrenome,
        String clienteEmail
) {
}
