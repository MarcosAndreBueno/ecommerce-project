package com.ecommerce.cliente_service.model.dto;

import com.ecommerce.cliente_service.model.Cliente;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {

    public Cliente toCliente(@Valid ClienteRequest request) {
        if (request == null) {
            return null;
        }
        return Cliente.builder()
                .id(request.id())
                .nome(request.nome())
                .sobrenome(request.sobrenome())
                .email(request.email())
                .endereco(request.endereco())
                .build();
    }

    public ClienteResponse fromCliente(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getSobrenome(),
                cliente.getEmail(),
                cliente.getEndereco()
        );
    }
}
