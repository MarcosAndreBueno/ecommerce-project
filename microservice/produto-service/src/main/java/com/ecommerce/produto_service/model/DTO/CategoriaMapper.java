package com.ecommerce.produto_service.model.DTO;

import com.ecommerce.produto_service.model.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriaMapper {

    public Categoria toCategoria(CategoriaRequest request) {
        return Categoria.builder()
                .id(request.id())
                .nome(request.nome())
                .descricao(request.descricao())
                .build();
    }

    public CategoriaResponse toCategoriaResponse(Categoria categoria) {
        return new CategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }
}
