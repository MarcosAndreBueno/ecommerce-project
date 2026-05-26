package com.ecommerce.pedido_service.circuitbreaker;

import com.ecommerce.pedido_service.httpclient.ClienteHttpClient;
import com.ecommerce.pedido_service.model.DTO.ClienteResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteClientService {

    private static final Logger log = LoggerFactory.getLogger(ClienteClientService.class);
    private final ClienteHttpClient clienteHttpClient;

    @CircuitBreaker(name = "cliente", fallbackMethod = "fallbackBuscarPorId")
    @Retry(name = "cliente")
    public Optional<ClienteResponse> buscarPorId(String clienteId) {
        return clienteHttpClient.findClienteById(clienteId);
    }

    public Optional<ClienteResponse> fallbackBuscarPorId(String clienteId, Throwable t) {
        log.warn("Falha ao buscar cliente id {}: {}", clienteId, t.getMessage());
        return Optional.empty();
    }
}
