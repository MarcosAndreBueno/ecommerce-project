package com.ecommerce.pedido_service.circuitbreaker;

import com.ecommerce.pedido_service.httpclient.ProdutoHttpClient;
import com.ecommerce.pedido_service.model.DTO.ProdutoCompraRequest;
import com.ecommerce.pedido_service.model.DTO.ProdutoCompraResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoClientService {

    private static final Logger log = LoggerFactory.getLogger(ProdutoClientService.class);
    private final ProdutoHttpClient produtoHttpClient;

    @CircuitBreaker(name = "produto", fallbackMethod = "fallbackComprarProdutos")
    @Retry(name = "produto")
    public Optional<List<ProdutoCompraResponse>> comprarProdutos(List<ProdutoCompraRequest> request) {
        return produtoHttpClient.comprarProdutos(request);
    }

    public Optional<List<ProdutoCompraResponse>> fallbackComprarProdutos(List<ProdutoCompraRequest> request, Throwable t) {
        log.warn("Falha ao comprar produtos: {}", t.getMessage());
        return Optional.empty();
    }
}
