package com.ecommerce.pedido_service.model.DTO;

import com.ecommerce.pedido_service.enums.MetodoPagamento;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.math.BigDecimal;

@JsonInclude(Include.NON_EMPTY)
public record PedidoResponse(
        Integer id,
        String referencias,
        BigDecimal valorTotal,
        MetodoPagamento metodoPagamento,
        String clienteId
) {

}
