package com.ecommerce.pedido_service.httpclient;

import com.ecommerce.pedido_service.model.DTO.PagamentoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "pagamento-service",
    url = "${application.config.pagamento-url}"
)
public interface PagamentoHttpClient {

  @PostMapping
  Integer iniciarProcessoPagamento(@RequestBody PagamentoRequest request);
}
