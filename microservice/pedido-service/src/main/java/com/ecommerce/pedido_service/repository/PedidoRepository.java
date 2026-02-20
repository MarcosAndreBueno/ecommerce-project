package com.ecommerce.pedido_service.repository;

import com.ecommerce.pedido_service.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
