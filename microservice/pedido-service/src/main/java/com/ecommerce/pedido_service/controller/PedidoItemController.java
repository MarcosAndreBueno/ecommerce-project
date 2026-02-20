package com.ecommerce.pedido_service.controller;


import com.ecommerce.pedido_service.model.DTO.PedidoItemResponse;
import com.ecommerce.pedido_service.service.PedidoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedido-itens")
@RequiredArgsConstructor
public class PedidoItemController {

    private final PedidoItemService pedidoItemService;

    //Listar pedido-itens associados a um pedido
    @GetMapping("/pedidos/{pedido-id}")
    public ResponseEntity<List<PedidoItemResponse>> findById(
            @PathVariable("pedido-id") Integer id
    ) {
        return ResponseEntity.ok(pedidoItemService.findAllByPedidoId(id));
    }
}
