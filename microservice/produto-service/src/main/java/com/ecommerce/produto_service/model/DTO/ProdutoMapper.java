package com.ecommerce.produto_service.model.DTO;

import com.ecommerce.produto_service.model.Categoria;
import com.ecommerce.produto_service.model.Produto;
import org.springframework.stereotype.Service;

@Service
public class ProdutoMapper {
    public Produto toProduto(ProdutoRequest request) {
        return Produto.builder()
                .id(request.id())
                .nome(request.nome())
                .descricao(request.descricao())
                .quantidadeDisponivel(request.quantidadeDisponivel())
                .preco(request.preco())
                .categoria(Categoria.builder()
                        .id(request.categoriaId())
                        .build())
                .build();
    }

    public ProdutoResponse toProdutoResponse(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getQuantidadeDisponivel(),
                produto.getPreco(),
                produto.getCategoria().getId(),
                produto.getCategoria().getNome(),
                produto.getCategoria().getDescricao()
        );
    }

    public ProdutoCompraResponse toProdutoCompraResponse(Produto produto, Integer quantidade) {
        return new ProdutoCompraResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                quantidade
        );
    }
}