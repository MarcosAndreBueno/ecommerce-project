package com.ecommerce.pagamento_service.service;

import com.ecommerce.pagamento_service.mensageria.PagamentoProducer;
import com.ecommerce.pagamento_service.mensageria.payload.PagamentoConfirmacaoPayload;
import com.ecommerce.pagamento_service.model.DTO.PagamentoMapper;
import com.ecommerce.pagamento_service.model.DTO.PagamentoRequest;
import com.ecommerce.pagamento_service.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final PagamentoMapper pagamentoMapper;
    private final PagamentoProducer pagamentoProducer;

    public Integer addPagamento(PagamentoRequest request) {
        var pagamento = this.pagamentoRepository.save(this.pagamentoMapper.toPagamento(request));

        this.pagamentoProducer.enviarNotificacaoPagamentoConfirmado(
                new PagamentoConfirmacaoPayload(
                        request.pedidoReferencias(),
                        request.valorTotal(),
                        request.metodoPagamento(),
                        request.cliente().nome(),
                        request.cliente().sobrenome(),
                        request.cliente().email()
                )
        );

        return pagamento.getId();
    }
}
