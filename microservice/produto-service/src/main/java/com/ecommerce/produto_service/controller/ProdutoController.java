package com.ecommerce.produto_service.controller;

import com.ecommerce.produto_service.model.DTO.ProdutoCompraRequest;
import com.ecommerce.produto_service.model.DTO.ProdutoCompraResponse;
import com.ecommerce.produto_service.model.DTO.ProdutoRequest;
import com.ecommerce.produto_service.model.DTO.ProdutoResponse;
import com.ecommerce.produto_service.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Integer> addProduto(
            @RequestBody @Valid ProdutoRequest request
    ) {
        return ResponseEntity.ok(produtoService.addProduto(request));
    }

    @PostMapping("/comprar")
    public ResponseEntity<List<ProdutoCompraResponse>> comprarProdutos(
            @RequestBody List<ProdutoCompraRequest> request
    ) {
        return ResponseEntity.ok(produtoService.comprarProdutos(request));
    }

    @GetMapping("/{produto-id}")
    public ResponseEntity<ProdutoResponse> findById(
            @PathVariable("produto-id") Integer id
    ) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }
}