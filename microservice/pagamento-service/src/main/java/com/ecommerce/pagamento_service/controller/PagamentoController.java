package com.ecommerce.pagamento_service.controller;

import com.ecommerce.pagamento_service.model.DTO.PagamentoRequest;
import com.ecommerce.pagamento_service.service.PagamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoService service;

    @PostMapping
    public ResponseEntity<Integer> addPagamento(
            @RequestBody @Valid PagamentoRequest request
    ) {
        return ResponseEntity.ok(this.service.addPagamento(request));
    }
}
