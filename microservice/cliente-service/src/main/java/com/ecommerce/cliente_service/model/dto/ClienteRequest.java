package com.ecommerce.cliente_service.model.dto;

import com.ecommerce.cliente_service.model.Endereco;
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
        String email,
        //validação na classe Endereco
        Endereco endereco
) {

}
