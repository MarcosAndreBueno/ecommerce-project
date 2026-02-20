package com.ecommerce.pagamento_service.model;


import com.ecommerce.pagamento_service.enums.MetodoPagamento;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;

    private Integer pedidoId;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime dataUltimaModificacao;

}
