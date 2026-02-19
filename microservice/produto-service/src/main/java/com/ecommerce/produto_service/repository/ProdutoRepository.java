package com.ecommerce.produto_service.repository;

import com.ecommerce.produto_service.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findAllByIdInOrderById(List<Integer> ids);
}