package com.ecommerce.pagamento_service.model.DTO;

import com.ecommerce.pagamento_service.model.Pagamento;
import org.springframework.stereotype.Service;

@Service
public class PagamentoMapper {

    public Pagamento toPagamento(PagamentoRequest request) {
        if (request == null) {
            return null;
        }
        return Pagamento.builder()
                .id(request.id())
                .metodoPagamento(request.metodoPagamento())
                .valorTotal(request.valorTotal())
                .pedidoId(request.pedidoId())
                .build();
    }
}
