package com.ecommerce.cliente_service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClienteNotFoundException extends RuntimeException{

    private final String msg;
}
