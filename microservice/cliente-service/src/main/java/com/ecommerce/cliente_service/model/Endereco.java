package com.ecommerce.cliente_service.model;


import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
public class Endereco {

    private String rua;
    private String numero;
    private String cep;
}