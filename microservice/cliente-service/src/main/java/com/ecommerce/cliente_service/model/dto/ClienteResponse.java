package com.ecommerce.cliente_service.model.dto;

import com.ecommerce.cliente_service.model.Endereco;

public record ClienteResponse(
        String id,
        String nome,
        String sobrenome,
        String email,
        Endereco endereco
) {
}
