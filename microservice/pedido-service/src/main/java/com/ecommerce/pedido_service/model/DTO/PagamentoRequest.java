package com.ecommerce.pedido_service.model.DTO;

import com.ecommerce.pedido_service.enums.MetodoPagamento;

import java.math.BigDecimal;

public record PagamentoRequest(
    BigDecimal valorTotal,
    MetodoPagamento metodoPagamento,
    Integer pedidoId,
    String pedidoReference,
    ClienteResponse clienteResponse
) {
}
