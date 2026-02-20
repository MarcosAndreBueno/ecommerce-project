package com.ecommerce.pedido_service.openfeign;

import com.ecommerce.pedido_service.model.DTO.ProdutoCompraRequest;
import com.ecommerce.pedido_service.model.DTO.ProdutoCompraResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "produto-service",
        url = "${application.config.produto-url}"
)
public interface ProdutoOpenFeign {

    @GetMapping("/comprar")
    Optional<List<ProdutoCompraResponse>> comprarProdutos(@RequestBody List<ProdutoCompraRequest> request);
}
