package com.ecommerce.pedido_service.mensageria.payload;


import com.ecommerce.pedido_service.model.enums.MetodoPagamento;
import com.ecommerce.pedido_service.model.DTO.ClienteResponse;
import com.ecommerce.pedido_service.model.DTO.ProdutoCompraResponse;

import java.math.BigDecimal;
import java.util.List;

public record PedidoConfirmacaoPayload(
        String pedidoReferencias,
        BigDecimal valorTotal,
        MetodoPagamento metodoPagamento,
        ClienteResponse cliente,
        List<ProdutoCompraResponse> produtos
) {
}
