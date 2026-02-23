package com.ecommerce.pedido_service.mensageria.payload;


import com.ecommerce.pedido_service.enums.MetodoPagamento;
import com.ecommerce.pedido_service.model.DTO.ClienteResponse;
import com.ecommerce.pedido_service.model.DTO.ProdutoCompraResponse;

import java.math.BigDecimal;
import java.util.List;

public record PedidoConfirmacao(
        String pedidoReferencia,
        BigDecimal valorTotal,
        MetodoPagamento metodoPagamento,
        ClienteResponse clienteResponse,
        List<ProdutoCompraResponse> produtoCompraResponses
) {
}
