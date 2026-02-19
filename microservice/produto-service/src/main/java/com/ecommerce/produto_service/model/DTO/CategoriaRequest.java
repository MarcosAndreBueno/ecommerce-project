package com.ecommerce.produto_service.model.DTO;

import jakarta.validation.constraints.NotNull;

public record CategoriaRequest (
        Integer id,
        @NotNull(message = "Nome da categoria é obrigatório")
        String nome,
        @NotNull(message = "Descrição da categoria é obrigatória")
        String descricao
) {
}
