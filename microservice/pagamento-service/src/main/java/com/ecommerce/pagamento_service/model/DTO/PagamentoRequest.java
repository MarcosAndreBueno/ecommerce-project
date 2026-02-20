package com.ecommerce.pagamento_service.model.DTO;

import com.ecommerce.pagamento_service.enums.MetodoPagamento;

import java.math.BigDecimal;

public record PagamentoRequest(
        Integer id,
        BigDecimal valorTotal,
        MetodoPagamento metodoPagamento,
        Integer pedidoId,
        String pedidoReferencias,
        ClienteRequest clienteRequest
) {
}
