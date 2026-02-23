package com.ecommerce.notificacao_service.model.DTO;

public record ClienteRequest(
        String id,
        String nome,
        String sobrenome,
        String email
) {

}
