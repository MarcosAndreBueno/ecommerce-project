package com.ecommerce.notificacao_service.model.DTO;

import java.math.BigDecimal;

public record ProdutoRequest(
        Integer produtoId,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer quantidade
) {
}
