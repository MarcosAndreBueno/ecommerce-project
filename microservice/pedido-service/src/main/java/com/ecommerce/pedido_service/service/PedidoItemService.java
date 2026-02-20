package com.ecommerce.pedido_service.service;

import com.ecommerce.pedido_service.model.DTO.PedidoItemMapper;
import com.ecommerce.pedido_service.model.DTO.PedidoItemRequest;
import com.ecommerce.pedido_service.model.DTO.PedidoItemResponse;
import com.ecommerce.pedido_service.repository.PedidoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoItemService {

    private final PedidoItemRepository pedidoItemRepository;
    private final PedidoItemMapper pedidoItemMapper;

    public Integer addPedidoItem(PedidoItemRequest request) {
        var pedidoItem = pedidoItemMapper.toPedidoItem(request);
        return pedidoItemRepository.save(pedidoItem).getId();
    }

    // através do pedidoId encontrar todos pedidoItens associados
    public List<PedidoItemResponse> findAllByPedidoId(Integer id) {
        return pedidoItemRepository.findAllByPedidoId(id)
                .stream()
                .map(pedidoItemMapper::toPedidoItemResponse)
                .collect(Collectors.toList());
    }
}
