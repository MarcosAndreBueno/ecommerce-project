package com.ecommerce.pedido_service.config;

import com.ecommerce.pedido_service.httpclient.PagamentoHttpClient;
import com.ecommerce.pedido_service.model.DTO.PagamentoRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoClientService {

    private static final Logger log = LoggerFactory.getLogger(PagamentoClientService.class);
    private final PagamentoHttpClient pagamentoHttpClient;

    @CircuitBreaker(name = "pagamento", fallbackMethod = "fallbackProcessar")
    @Retry(name = "pagamento")
    public Integer processar(PagamentoRequest request) {
        return pagamentoHttpClient.iniciarProcessoPagamento(request);
    }

    public Integer fallbackProcessar(PagamentoRequest request, Throwable t) {
        log.warn("Falha ao processar pagamento: {}", t.getMessage());
        return null;
    }
}
