package com.ecommerce.notificacao_service.mensageria.payload;

import com.ecommerce.notificacao_service.model.DTO.ClienteRequest;
import com.ecommerce.notificacao_service.model.DTO.ProdutoRequest;
import com.ecommerce.notificacao_service.model.enums.MetodoPagamento;

import java.math.BigDecimal;
import java.util.List;

public record PedidoConfirmacaoPayload(
        String pedidoReferencias,
        BigDecimal valorTotal,
        MetodoPagamento metodoPagamento,
        ClienteRequest cliente,
        List<ProdutoRequest> produtos
) {
}
