package com.ecommerce.pedido_service.model.DTO;

import com.ecommerce.pedido_service.model.Pedido;
import com.ecommerce.pedido_service.model.PedidoItem;
import org.springframework.stereotype.Service;

@Service
public class PedidoItemMapper {
    
    public PedidoItem toPedidoItem(PedidoItemRequest request) {
        return PedidoItem.builder()
                .produtoId(request.produtoId())
                .pedido(Pedido.builder()
                        .id(request.pedidoId())
                        .build())
                .quantidade(request.quantidade())
                .build();
    }

    public PedidoItemResponse toPedidoItemResponse(PedidoItem pedidoItem) {
        return new PedidoItemResponse(
                pedidoItem.getId(),
                pedidoItem.getQuantidade()
                // !!! implementar preco !!!
        );
    }
}
