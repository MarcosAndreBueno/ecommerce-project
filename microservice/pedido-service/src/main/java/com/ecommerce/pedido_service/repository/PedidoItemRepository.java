package com.ecommerce.pedido_service.repository;

import com.ecommerce.pedido_service.model.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer> {

    List<PedidoItem> findAllByPedidoId(Integer pedidoId);
}
