package com.ecommerce.pedido_service.service;


import com.ecommerce.pedido_service.exception.PedidoException;
import com.ecommerce.pedido_service.httpclient.ClienteHttpClient;
import com.ecommerce.pedido_service.httpclient.PagamentoHttpClient;
import com.ecommerce.pedido_service.httpclient.ProdutoHttpClient;
import com.ecommerce.pedido_service.mensageria.payload.PedidoConfirmacaoPayload;
import com.ecommerce.pedido_service.mensageria.PedidoProducer;
import com.ecommerce.pedido_service.model.DTO.*;
import com.ecommerce.pedido_service.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final ClienteHttpClient clienteHttpClient;
    private final ProdutoHttpClient produtoHttpClient;
    private final PedidoItemService pedidoItemService;
    private final PedidoProducer pedidoProducer;
    private final PagamentoHttpClient pagamentoHttpClient;

    @Transactional
    public Integer addPedido(PedidoRequest request) {

        // validar cliente com OpenFeign
        var cliente = this.clienteHttpClient.findClienteById(request.clienteId())
                .orElseThrow(() -> new PedidoException("Não foi possível criar pedido, pois nenhum cliente foi encontrado com o id fornecido"));

        // validar produto com OpenFeign
        var produtosComprados = produtoHttpClient.comprarProdutos(request.produtos())
                .orElseThrow(() -> new PedidoException("Não foi possível criar pedido, pois nenhum produto foi encontrado com o id fornecido"));

        var pedido = this.pedidoRepository.save(pedidoMapper.toPedido(request));

        // persistir pedidos
        for (ProdutoCompraRequest requestCompra : request.produtos()) {
            pedidoItemService.addPedidoItem(
                    new PedidoItemRequest(
                            null,
                            pedido.getId(),
                            requestCompra.produtoId(),
                            requestCompra.quantidade()
                    )
            );
        }

        // iniciar processo de pagamento
        var pagamentoRequest = new PagamentoRequest(
                request.valorTotal(),
                request.metodoPagamento(),
                pedido.getId(),
                pedido.getReferencias(),
                cliente
        );
        pagamentoHttpClient.iniciarProcessoPagamento(pagamentoRequest);

        // enviar confirmação de pedido via Kafka
        pedidoProducer.enviarNotificacaoConfimacaoPedido(
                new PedidoConfirmacaoPayload(
                        request.referencias(),
                        request.valorTotal(),
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
