package com.ecommerce.pedido_service.model.DTO;

import java.math.BigDecimal;

public record PedidoItemRequest(
        Integer id,
        Integer pedidoId,
        Integer produtoId,
        Integer quantidade,
        BigDecimal preco
) {
}
