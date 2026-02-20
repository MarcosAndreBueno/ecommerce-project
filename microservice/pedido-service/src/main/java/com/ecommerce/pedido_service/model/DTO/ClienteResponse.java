package com.ecommerce.pedido_service.model.DTO;

public record ClienteResponse(
        String id,
        String nome,
        String sobrenome,
        String email
) {
}
