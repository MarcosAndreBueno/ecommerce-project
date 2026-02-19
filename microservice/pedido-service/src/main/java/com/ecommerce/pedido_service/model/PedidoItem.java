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
@Table(name = "customer_line")
public class PedidoItem {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Pedido pedido;
    private Integer produtoId;
    private Integer quantidade;
    private BigInteger preco;
}
