package com.ecommerce.produto_service.model.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.math.BigInteger;

public record ProdutoRequest(

        Integer id,
        @NotNull(message = "Nome do produto é obrigatório")
        String nome,
        @NotNull(message = "Descrição do produto é obrigatória")
        String descricao,
        @Positive(message = "Quatidade do produto deve ser positiva")
        Integer quantidadeDisponivel,
        @Positive(message = "Preço do produto deve ser positivo")
        BigDecimal preco,
        @NotNull(message = "Categoria do produto é obrigatório")
        Integer categoriaId
) {
}