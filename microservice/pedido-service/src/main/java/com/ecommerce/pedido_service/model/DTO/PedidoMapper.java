package com.ecommerce.pedido_service.model.DTO;

import com.ecommerce.pedido_service.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoMapper {


    public Pedido toPedido(PedidoRequest request) {
        if (request == null) {
            return null;
        }
        return Pedido.builder()
                .id(request.id())
                .referencias(request.referencias())
                .metodoPagamento(request.metodoPagamento())
                .clienteId(request.clienteId())
                .build();
    }

    public PedidoResponse toPedidoResponse(Pedido pedido) {
        return new PedidoResponse(
                pedido.getId(),
                pedido.getReferencias(),
                pedido.getValorTotal(),
                pedido.getMetodoPagamento(),
                pedido.getClienteId()
        );
    }
}
