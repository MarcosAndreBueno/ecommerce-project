package com.ecommerce.pedido_service.model.DTO;

public record ProdutoCompraResponse(
        Integer produtoId,
        String nome,
        String descricao,
        Integer quantidade
        // !!! implementar preco !!!
) {
}
