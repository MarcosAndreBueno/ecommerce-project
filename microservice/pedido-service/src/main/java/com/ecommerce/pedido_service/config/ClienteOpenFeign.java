package com.ecommerce.pedido_service.config;

import com.ecommerce.pedido_service.model.DTO.ClienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "cliente-service",
        url = "${application.config.cliente-url}"
)
public interface ClienteOpenFeign {

    @GetMapping("/{cliente-id}")
    Optional<ClienteResponse> findClienteById(@PathVariable("cliente-id") String clienteId);
}
