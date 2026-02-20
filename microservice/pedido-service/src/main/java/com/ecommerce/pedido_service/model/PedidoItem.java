package com.ecommerce.pedido_service.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pedido_item")
public class PedidoItem {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    private Integer produtoId;
    private Integer quantidade;
    // !!! implementar preco !!!
}
