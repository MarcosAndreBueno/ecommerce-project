package com.ecommerce.pedido_service.model.DTO;

import java.math.BigDecimal;

public record ProdutoCompraResponse(
        Integer produtoId,
        String nome,
        String descricao,
        Integer quantidade,
        BigDecimal preco
) {
}
