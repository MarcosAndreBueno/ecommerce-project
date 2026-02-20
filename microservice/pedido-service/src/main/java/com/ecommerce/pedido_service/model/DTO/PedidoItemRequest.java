package com.ecommerce.pedido_service.model.DTO;

public record PedidoItemRequest(
        Integer id,
        Integer pedidoId,
        Integer produtoId,
        Integer quantidade
) {
}
