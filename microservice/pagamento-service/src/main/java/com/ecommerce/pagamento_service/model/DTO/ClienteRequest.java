package com.ecommerce.pagamento_service.model.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ClienteRequest(
        String id,
        @NotNull(message = "Nome do cliente é um campo obrigatório")
        String nome,
        @NotNull(message = "Sobrenome do cliente é um campo obrigatório")
        String sobrenome,
        @NotNull(message = "E-mail do cliente é um campo obrigatório")
        @Email(message = "O e-mail não é válido")
        String email
) {

}
