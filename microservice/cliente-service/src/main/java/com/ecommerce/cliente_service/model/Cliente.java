package com.ecommerce.cliente_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Cliente {

    @Id
    private String id;
    private String nome;
    private String sobrenome;
    private String email;
    private Endereco endereco;
}
