package com.ecommerce.produto_service.controller;

import com.ecommerce.produto_service.model.Categoria;
import com.ecommerce.produto_service.model.DTO.CategoriaRequest;
import com.ecommerce.produto_service.model.DTO.CategoriaResponse;
import com.ecommerce.produto_service.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Integer> addCategoria(
            @RequestBody @Valid CategoriaRequest request
    ) {
        return ResponseEntity.ok(categoriaService.addCategoria(request));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> findAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("/{categoria-id}")
    public ResponseEntity<CategoriaResponse> findById(@PathVariable("categoria-id") Integer id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }
}
