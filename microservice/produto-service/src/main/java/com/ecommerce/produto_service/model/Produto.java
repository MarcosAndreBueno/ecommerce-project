package com.ecommerce.produto_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String descricao;
    @Column(name = "quantidade_disponivel")
    private Integer quantidadeDisponivel;
    private BigDecimal preco;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}