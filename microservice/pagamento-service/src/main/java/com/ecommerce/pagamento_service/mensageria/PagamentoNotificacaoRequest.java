package com.ecommerce.pagamento_service.mensageria;


import com.ecommerce.pagamento_service.enums.MetodoPagamento;

import java.math.BigDecimal;

public record PagamentoNotificacaoRequest(
        String pedidoReferencias,
        BigDecimal valorTotal,
        MetodoPagamento metodoPagamento,
        String clienteNome,
        String clienteSobrenome,
        String clienteEmails
) {
}
