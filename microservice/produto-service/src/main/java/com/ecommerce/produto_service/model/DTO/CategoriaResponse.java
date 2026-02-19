package com.ecommerce.produto_service.model.DTO;

import com.ecommerce.produto_service.model.Produto;

import java.util.List;

public record CategoriaResponse(
        Integer id,
        String nome,
        String descricao
) {
}
