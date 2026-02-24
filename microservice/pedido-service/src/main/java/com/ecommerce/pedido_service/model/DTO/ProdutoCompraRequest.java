package com.ecommerce.pedido_service.model.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@Validated
public record ProdutoCompraRequest(
        @NotNull(message = "Id do produto é obrigatório")
        Integer produtoId,
        @Positive(message = "Quantidade do produto deve ser positiva")
        Integer quantidade
) {
}