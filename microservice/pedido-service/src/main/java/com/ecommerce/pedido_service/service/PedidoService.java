package com.ecommerce.pedido_service.service;


import com.ecommerce.pedido_service.config.ClienteClientService;
import com.ecommerce.pedido_service.config.PagamentoClientService;
import com.ecommerce.pedido_service.config.ProdutoClientService;
import com.ecommerce.pedido_service.exception.PedidoException;
import com.ecommerce.pedido_service.mensageria.payload.PedidoConfirmacaoPayload;
import com.ecommerce.pedido_service.mensageria.PedidoProducer;
import com.ecommerce.pedido_service.model.DTO.*;
import com.ecommerce.pedido_service.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final ClienteClientService clienteClientService;
    private final ProdutoClientService produtoClientService;
    private final PedidoItemService pedidoItemService;
    private final PedidoProducer pedidoProducer;
    private final PagamentoClientService pagamentoClientService;

    @Transactional
    public Integer addPedido(PedidoRequest request) {

        var cliente = this.clienteClientService.buscarPorId(request.clienteId())
                .orElseThrow(() -> new PedidoException("Não foi possível criar pedido, pois nenhum cliente foi encontrado com o id fornecido"));

        var produtosComprados = produtoClientService.comprarProdutos(request.produtos())
                .orElseThrow(() -> new PedidoException("Não foi possível criar pedido, pois nenhum produto foi encontrado com o id fornecido"));

        BigDecimal valorTotal = produtosComprados.stream()
                .map(ProdutoCompraResponse::preco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        var pedido = this.pedidoRepository.save(pedidoMapper.toPedido(request, valorTotal));
        for (ProdutoCompraRequest requestCompra : request.produtos()) {
            pedidoItemService.addPedidoItem(
                    new PedidoItemRequest(
                            null,
                            pedido.getId(),
                            requestCompra.produtoId(),
                            requestCompra.quantidade(),
                            produtosComprados.stream()
                                    .filter(p -> p.produtoId().equals(requestCompra.produtoId()))
                                    .findFirst()
                                    .get().preco()
                    )
            );
        }

        var pagamentoRequest = new PagamentoRequest(
                valorTotal,
                request.metodoPagamento(),
                pedido.getId(),
                pedido.getReferencias(),
                cliente
        );
        pagamentoClientService.processar(pagamentoRequest);

        // enviar confirmação de pedido via Kafka
        pedidoProducer.enviarNotificacaoConfimacaoPedido(
                new PedidoConfirmacaoPayload(
                        request.referencias(),
                        valorTotal,
                        request.metodoPagamento(),
                        cliente,
                        produtosComprados
                )
        );


        return pedido.getId();
    }

    public List<PedidoResponse> findAllPedidos() {
        return this.pedidoRepository.findAll()
                .stream()
                .map(this.pedidoMapper::toPedidoResponse)
                .collect(Collectors.toList());
    }

    public PedidoResponse findById(Integer id) {
        return this.pedidoRepository.findById(id)
                .map(this.pedidoMapper::toPedidoResponse)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Nenhum pedido encontrado para o ID: %d", id)));
    }
}
