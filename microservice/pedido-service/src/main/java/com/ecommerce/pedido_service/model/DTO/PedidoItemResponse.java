package com.ecommerce.pedido_service.model.DTO;

import java.math.BigDecimal;

public record PedidoItemResponse(
        Integer id,
        Integer quantidade,
        BigDecimal preco
) {
}
