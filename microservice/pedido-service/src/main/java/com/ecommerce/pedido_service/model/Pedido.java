package com.ecommerce.pedido_service.model;

import com.ecommerce.pedido_service.model.enums.MetodoPagamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class) // para autogerenciar Date
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true,  nullable = false)
    private String referencias;

    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;

    private String clienteId;

    @OneToMany(mappedBy = "pedido")
    private List<PedidoItem> pedidoItems;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime dataUltimaModificacao;
}

