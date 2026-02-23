package com.ecommerce.pedido_service.model.DTO;

import com.ecommerce.pedido_service.model.enums.MetodoPagamento;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(Include.NON_EMPTY)
public record PedidoRequest(
        Integer id,
        String referencias,
        @Positive(message = "Pedido deve ter valor positivo") // !!! implementar valorTotal dinamicamente !!!
        BigDecimal valorTotal,
        @NotNull(message = "Um método de pagamento deve ser informado")
        MetodoPagamento metodoPagamento,
        @NotBlank(message = "Cliente deve ser informado")
        String clienteId,
        @NotEmpty(message = "Deve ser feita a compra de pelo menos um produto")
        List<ProdutoCompraRequest> produtos
) {

}
