package com.ecommerce.pedido_service.controller;

import com.ecommerce.pedido_service.model.DTO.PedidoRequest;
import com.ecommerce.pedido_service.model.DTO.PedidoResponse;
import com.ecommerce.pedido_service.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Integer> addPedido(
            @RequestBody @Valid PedidoRequest request
    ) {
        return ResponseEntity.ok(this.pedidoService.addPedido(request));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> findAll() {
        return ResponseEntity.ok(this.pedidoService.findAllPedidos());
    }

    @GetMapping("/{pedido-id}")
    public ResponseEntity<PedidoResponse> findById(
            @PathVariable("pedido-id") Integer id
    ) {
        return ResponseEntity.ok(this.pedidoService.findById(id));
    }
}
