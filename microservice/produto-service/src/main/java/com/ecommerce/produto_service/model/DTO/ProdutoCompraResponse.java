package com.ecommerce.produto_service.model.DTO;

import java.math.BigDecimal;

public record ProdutoCompraResponse(
        Integer produtoId,
        String nome,
        String descricao,
        BigDecimal preco,
        double quantidade
) {
}
