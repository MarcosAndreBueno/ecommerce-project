package com.ecommerce.produto_service.model.DTO;

import java.math.BigDecimal;

public record ProdutoResponse(
        Integer id,
        String nome,
        String descricao,
        Integer quantidadeDisponivel,
        BigDecimal preco,
        Integer categoriaId,
        String categoriaNome,
        String categoriaDescricao
) {
}
