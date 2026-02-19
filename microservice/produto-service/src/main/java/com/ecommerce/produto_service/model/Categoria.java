package com.ecommerce.produto_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Categoria {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Produto> produtos;
}