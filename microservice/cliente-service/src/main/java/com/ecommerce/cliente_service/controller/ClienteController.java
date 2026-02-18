package com.ecommerce.cliente_service.controller;

import com.ecommerce.cliente_service.model.dto.ClienteRequest;
import com.ecommerce.cliente_service.model.dto.ClienteResponse;
import com.ecommerce.cliente_service.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<String> createCliente(@RequestBody @Valid ClienteRequest request) {
        return ResponseEntity.ok(this.clienteService.addCliente(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCliente(
            @RequestBody @Valid ClienteRequest request
    ) {
        this.clienteService.updateCliente(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAll() {
        return ResponseEntity.ok(this.clienteService.findAllClientes());
    }

    @GetMapping("/{cliente-id}")
    public ResponseEntity<ClienteResponse> findById(
            @PathVariable("cliente-id") String clienteId
    ) {
        return ResponseEntity.ok(this.clienteService.findById(clienteId));
    }

    @DeleteMapping("/{cliente-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("cliente-id") String clienteId
    ) {
        this.clienteService.deleteCliente(clienteId);
        return ResponseEntity.accepted().build();
    }
}