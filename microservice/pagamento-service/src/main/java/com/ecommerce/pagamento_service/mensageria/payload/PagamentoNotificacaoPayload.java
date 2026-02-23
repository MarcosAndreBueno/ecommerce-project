package com.ecommerce.pagamento_service.mensageria.payload;


import com.ecommerce.pagamento_service.model.enums.MetodoPagamento;

import java.math.BigDecimal;

public record PagamentoNotificacaoPayload(
        String pedidoReferencias,
        BigDecimal valorTotal,
        MetodoPagamento metodoPagamento,
        String clienteNome,
        String clienteSobrenome,
        String clienteEmails
) {
}
