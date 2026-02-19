package com.ecommerce.produto_service.model.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProdutoCompraRequest(
        @NotNull(message = "Id do produto é obrigatório")
        Integer produtoId,
        @Positive(message = "Quantidade do produto é obrigatório")
        Integer quantidade
) {
}