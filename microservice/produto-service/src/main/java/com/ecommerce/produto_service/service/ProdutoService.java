package com.ecommerce.produto_service.service;

import com.ecommerce.produto_service.exception.ProdutoCompraException;
import com.ecommerce.produto_service.model.DTO.*;
import com.ecommerce.produto_service.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public Integer addProduto(
            ProdutoRequest request
    ) {
        var produto = produtoMapper.toProduto(request);
        return produtoRepository.save(produto).getId();
    }

    public ProdutoResponse findById(Integer id) {
        return produtoRepository.findById(id)
                .map(produtoMapper::toProdutoResponse)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado para o id: " + id));
    }

    public List<ProdutoResponse> findAll() {
        return produtoRepository.findAll()
                .stream()
                .map(produtoMapper::toProdutoResponse)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = ProdutoCompraException.class)
    public List<ProdutoCompraResponse> comprarProdutos(
            List<ProdutoCompraRequest> request
    ) {
        var produtosIds = request
                .stream()
                .map(ProdutoCompraRequest::produtoId)
                .toList();

        var produtosRegistrados = produtoRepository.findAllByIdInOrderById(produtosIds);

        // alertar caso não encontrar algum produto
        if (produtosIds.size() != produtosRegistrados.size()) {
            throw new ProdutoCompraException("Um ou mais produto não está registrado na base.");
        }

        var requestOrdenado = request
                .stream()
                .sorted(Comparator.comparing(ProdutoCompraRequest::produtoId))
                .toList();

        var produtosComprados = new ArrayList<ProdutoCompraResponse>();
        for (int i = 0; i < produtosRegistrados.size(); i++) {
            var produto = produtosRegistrados.get(i);
            var produtoRequest = requestOrdenado.get(i);
            if (produto.getQuantidadeDisponivel() < produtoRequest.quantidade()) {
                throw new ProdutoCompraException("Não há quantidade suficiente desse produto em estoque: " + produtoRequest.produtoId());
            }
            var novaQuantidadeDisponivel = produto.getQuantidadeDisponivel() - produtoRequest.quantidade();
            produto.setQuantidadeDisponivel(novaQuantidadeDisponivel);
            produtoRepository.save(produto);
            produtosComprados.add(produtoMapper.toProdutoCompraResponse(produto, produtoRequest.quantidade()));
        }

        return produtosComprados;
    }

}
