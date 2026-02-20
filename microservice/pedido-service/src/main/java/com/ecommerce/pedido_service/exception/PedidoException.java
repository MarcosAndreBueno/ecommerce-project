package com.ecommerce.pedido_service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PedidoException extends RuntimeException {
    private final String msg;
}