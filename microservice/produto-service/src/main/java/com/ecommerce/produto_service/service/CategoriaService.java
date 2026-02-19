package com.ecommerce.produto_service.service;

import com.ecommerce.produto_service.model.DTO.CategoriaRequest;
import com.ecommerce.produto_service.model.DTO.CategoriaResponse;
import com.ecommerce.produto_service.model.DTO.CategoriaMapper;
import com.ecommerce.produto_service.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public Integer addCategoria(
            CategoriaRequest request
    ) {
        var categoria = categoriaMapper.toCategoria(request);
        return categoriaRepository.save(categoria).getId();
    }

    public CategoriaResponse findById(Integer id) {
        return categoriaRepository.findById(id)
                .map(categoriaMapper::toCategoriaResponse)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada para o id: " + id));
    }

    public List<CategoriaResponse> findAll() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::toCategoriaResponse)
                .collect(Collectors.toList());
    }
}
